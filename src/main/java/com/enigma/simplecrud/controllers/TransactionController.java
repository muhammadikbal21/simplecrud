package com.enigma.simplecrud.controllers;

import com.enigma.simplecrud.entities.Food;
import com.enigma.simplecrud.entities.Transaction;
import com.enigma.simplecrud.entities.Users;
import com.enigma.simplecrud.exceptions.EntityNotFoundException;
import com.enigma.simplecrud.models.PagedList;
import com.enigma.simplecrud.models.ResponseMessage;
import com.enigma.simplecrud.models.transaction.TransactionElement;
import com.enigma.simplecrud.models.transaction.TransactionRequest;
import com.enigma.simplecrud.models.transaction.TransactionResponse;
import com.enigma.simplecrud.models.transaction.TransactionSearch;
import com.enigma.simplecrud.services.FoodService;
import com.enigma.simplecrud.services.TransactionService;
import com.enigma.simplecrud.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    private FoodService foodService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<TransactionResponse> add(@RequestBody @Valid TransactionRequest model) {
        Transaction entity = modelMapper.map(model, Transaction.class);

        Food food = foodService.findById(model.getFoodId());
        Users users = usersService.findById(model.getUserId());

        entity.setFood(food);
        entity.setTotal(entity.getQuantity() * entity.getFood().getPrice());
        entity.setUsers(users);
        entity.setQuantity(model.getQuantity());

        entity = service.save(entity);

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PagedList<TransactionElement>> findAll(
            @Valid TransactionSearch model
    ) {

        Transaction search = modelMapper.map(model, Transaction.class);

        Page<Transaction> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());
        List<Transaction> entities = entityPage.toList();

        List<TransactionElement> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionElement.class))
                .collect(Collectors.toList());

        PagedList<TransactionElement> data = new PagedList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionResponse> findById(@PathVariable Integer id) {
        Transaction entity  = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<TransactionResponse> removeById(@PathVariable Integer id) {
        Transaction entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }
}
