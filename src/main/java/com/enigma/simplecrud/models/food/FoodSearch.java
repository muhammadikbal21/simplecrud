package com.enigma.simplecrud.models.food;

import com.enigma.simplecrud.models.PageSearch;
import com.enigma.simplecrud.models.validation.Alphabetic;

public class FoodSearch extends PageSearch {

    @Alphabetic
    private String name;

    private String types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
