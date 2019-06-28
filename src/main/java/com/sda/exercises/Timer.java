package com.sda.exercises;

import java.util.List;
import java.util.Random;
import com.sda.exercises.models.animals.Animal;

public class Timer implements Runnable {
    private List<Animal> animals;
    private Random rand = new Random();

    Timer(List<Animal> animals) {
        this.animals = animals;
    }

    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                int milis = rand.nextInt(3000);
                Thread.sleep(milis);
                animals.forEach(Animal::increaseHungry);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
