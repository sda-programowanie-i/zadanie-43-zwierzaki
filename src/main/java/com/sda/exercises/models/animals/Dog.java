package com.sda.exercises.models.animals;

import java.util.HashSet;
import com.sda.exercises.models.food.Dish;

public class Dog extends Animal {

    public Dog(String name) {

        super(name);
        HashSet<Dish> foods = new HashSet<>();
        foods.add(Dish.BONE);
        foods.add(Dish.MEAT);
        super.setFavoriteFood(foods);
    }

}
