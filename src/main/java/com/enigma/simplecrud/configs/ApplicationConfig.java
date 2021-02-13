package com.enigma.simplecrud.configs;

import com.enigma.simplecrud.entities.Food;
import com.enigma.simplecrud.entities.Users;
import com.enigma.simplecrud.models.food.FoodModel;
import com.enigma.simplecrud.models.users.UsersModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(FoodModel.class, Food.class).addMappings(mapper -> {
            mapper.skip(Food::setId);
        });

//        modelMapper.typeMap(UsersModel.class, Users.class).addMappings(mapper -> {
//            mapper.skip(Users::setId);
//        });

        return modelMapper;
    }
}
