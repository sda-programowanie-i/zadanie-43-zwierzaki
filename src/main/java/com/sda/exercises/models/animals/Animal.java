package com.sda.exercises.models.animals;

import java.util.HashSet;
import java.util.Set;
import com.sda.exercises.models.exceptions.AnimalException;
import com.sda.exercises.models.exceptions.LackOfFoodException;
import com.sda.exercises.models.food.Dish;
import com.sda.exercises.models.food.Food;

public abstract class Animal {

    private String name;

    private int hungry;

    private Set<Dish> favoriteFood = new HashSet<>();

    Animal(String name) {
        this.name = name;
        this.hungry = 0;
    }

    void setFavoriteFood(Set<Dish> favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return this.name;
    }

    public int getHungry() {
        return hungry;
    }

    public void eat(Food food) throws AnimalException, LackOfFoodException {
        if (favoriteFood.contains(food.getDish())) {
            food.increase();
            if (hungry > 0) {
                hungry--;
                System.out.println(this.name + " eats " + food.getDish() + " mniam ");
            } else {
                throw new AnimalException("Animal " + this.name + " is full.");
            }
        } else
            throw new AnimalException("Animal " + this.name + " hates " + food);
    }

    public void increaseHungry() {
        System.out.println(this.name + " feels more hungry.");
        hungry++;
    }

    public boolean isHungry() {
        return hungry > 0;
    }
}
