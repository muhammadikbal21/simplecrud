package com.enigma.simplecrud.models.transaction;

import com.enigma.simplecrud.models.PageSearch;

public class TransactionSearch extends PageSearch {

    private Integer id;

    private Integer userId;

    private String food;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
