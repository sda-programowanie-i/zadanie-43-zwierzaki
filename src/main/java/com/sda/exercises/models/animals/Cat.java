package com.sda.exercises.models.animals;

import java.util.HashSet;
import com.sda.exercises.models.food.Dish;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        HashSet<Dish> foods = new HashSet<>();
        foods.add(Dish.MEAT);
        super.setFavoriteFood(foods);
    }

}
