package com.sda.exercises.models;

import java.util.*;
import com.sda.exercises.models.animals.Animal;
import com.sda.exercises.models.animals.Dog;
import com.sda.exercises.models.exceptions.AnimalException;
import com.sda.exercises.models.exceptions.LackOfFoodException;
import com.sda.exercises.models.food.Dish;
import com.sda.exercises.models.food.Food;

public class Person implements Runnable {

    private static final String SEPARATOR_LINE = "----------------------------------";
    private List<Animal> animals = new ArrayList<>();
    private Set<Food> foods = new HashSet<>();

    public void run() {
        buyAnimal(new Dog("Azor"));
//        buyAnimal(new Cat("Filemon"));
//        buyAnimal(new Dog("Szarik"));

        buyFood(new Food(Dish.BONE, 2));
        buyFood(new Food(Dish.MEAT, 0));

        for (int i = 0; i < 100; i++) {
            printHeader(i);
            feedAnimal();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buyAnimal(Animal animal) {
        this.animals.add(animal);
    }

    private void buyFood(final Food food) {
        System.out.println("I'm bying " + food.getDish());
        Optional<Food> optionalFood = foods.stream()
                                           .filter(c -> c.getDish() == food.getDish())
                                           .findFirst();
        if (optionalFood.isPresent()) {
            optionalFood.get()
                        .addFood(food.getAmount());
        } else
            foods.add(food);
    }

    private void feedAnimal() {
        animals.forEach(animal -> foods.forEach(f -> {
            if (animal.isHungry()) {
                try {
                    animal.eat(f);
                } catch (LackOfFoodException e) {
//                    System.out.println(e);
                    buyFood(new Food(e.getDish(), 2));
                } catch (AnimalException e) {
//                    System.out.println(e);
                }
            }
        }));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    private void printHeader(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SEPARATOR_LINE)
                     .append(System.lineSeparator())
                     .append(i)
                     .append(" | ");
        for (Animal animal : animals) {
            stringBuilder.append(animal.getName())
                         .append(" ")
                         .append(animal.getHungry())
                         .append(" | ");
        }

        for (Food food : foods) {
            stringBuilder.append(food.getDish())
                         .append(" = ")
                         .append(food.getAmount())
                         .append(", ");
        }
        stringBuilder.append(System.lineSeparator())
                     .append(SEPARATOR_LINE);
        System.out.println(stringBuilder.toString());
    }
}
