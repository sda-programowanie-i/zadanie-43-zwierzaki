package com.sda.exercises.models.food;

import com.sda.exercises.models.exceptions.LackOfFoodException;

public class Food {
    public Dish getDish() {
        return dish;
    }

    private Dish dish;

    public int getAmount() {
        return amount;
    }

    private int amount;

    public Food(
            Dish dish,
            int amount
    ) {
        this.dish = dish;
        this.amount = amount;
    }

    public void increase() throws LackOfFoodException {
        if (amount > 0)
            amount--;
        else
            throw new LackOfFoodException(this.dish);
    }

    public void addFood(int amount) {
        this.amount += amount;
    }

    public boolean isEmpty() {
        return this.amount == 0;
    }
}
