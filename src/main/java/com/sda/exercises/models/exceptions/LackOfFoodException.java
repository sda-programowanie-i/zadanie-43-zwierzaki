package com.sda.exercises.models.exceptions;

import com.sda.exercises.models.food.Dish;

public class LackOfFoodException extends Exception {
    private static final long serialVersionUID = 3981418284901585454L;

    public Dish getDish() {
        return dish;
    }

    private Dish dish;

    public LackOfFoodException(Dish dish) {
        this.dish = dish;
    }
}
