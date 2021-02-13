package com.enigma.simplecrud.models.food;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FoodModel {

    private Integer id;

    @NotBlank // notblank khusus string, integer tidak bisa
    @Size(min = 1)
    private String name;

    private String description;

    @NotNull // notnull khusus integer
    private Integer price;

    @NotBlank
    @Size(min = 1)
    private String types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
