package com.enigma.simplecrud.controllers;

import com.enigma.simplecrud.entities.Food;
import com.enigma.simplecrud.exceptions.EntityNotFoundException;
import com.enigma.simplecrud.models.PagedList;
import com.enigma.simplecrud.models.ResponseMessage;
import com.enigma.simplecrud.models.food.FoodModel;
import com.enigma.simplecrud.models.food.FoodSearch;
import com.enigma.simplecrud.services.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/foods")
@RestController
public class FoodController {

    @Autowired
    private FoodService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseMessage<PagedList<FoodModel>> findAll(
            @Valid FoodSearch model
    ) {

        Food search = modelMapper.map(model, Food.class);

        Page<Food> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());
        List<Food> entities = entityPage.toList();

        List<FoodModel> models = entities.stream()
                .map(e -> modelMapper.map(e, FoodModel.class))
                .collect(Collectors.toList());

        PagedList<FoodModel> data = new PagedList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());
        return ResponseMessage.success(data);
    }

    @PostMapping
    public ResponseMessage<FoodModel> add(@RequestBody @Valid FoodModel model) {
        Food entity = modelMapper.map(model, Food.class);
        entity = service.save(entity);

        FoodModel data = modelMapper.map(entity, FoodModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<FoodModel> findById(@PathVariable Integer id) {
        Food entity  = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        FoodModel data = modelMapper.map(entity, FoodModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<FoodModel> edit(
            @PathVariable Integer id, @RequestBody @Valid FoodModel model) {
        Food entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);

        FoodModel data = modelMapper.map(entity, FoodModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<FoodModel> removeById(@PathVariable Integer id) {
        Food entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        FoodModel data = modelMapper.map(entity, FoodModel.class);
        return ResponseMessage.success(data);
    }
}
