package com.enigma.simplecrud.services.impl;

import com.enigma.simplecrud.entities.Food;
import com.enigma.simplecrud.repositories.FoodRepository;
import com.enigma.simplecrud.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends CommonServiceImpl<Food, Integer> implements FoodService {

    @Autowired
    public FoodServiceImpl(FoodRepository repository) {
        super(repository);
    }
}
