package com.enigma.simplecrud.models.transaction;


import javax.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer foodId;

    @NotNull
    private Integer quantity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
