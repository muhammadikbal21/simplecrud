package com.enigma.simplecrud.repositories;

import com.enigma.simplecrud.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
