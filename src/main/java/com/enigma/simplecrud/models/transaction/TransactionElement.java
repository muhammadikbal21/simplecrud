package com.enigma.simplecrud.models.transaction;

import com.enigma.simplecrud.models.food.FoodModel;
import com.enigma.simplecrud.models.users.UsersModel;

public class TransactionElement {

    private Integer id;
    private UsersModel users;
    private FoodModel food;
    private Integer quantity;
    private Integer total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsersModel getUsers() {
        return users;
    }

    public void setUsers(UsersModel users) {
        this.users = users;
    }

    public FoodModel getFood() {
        return food;
    }

    public void setFood(FoodModel food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
