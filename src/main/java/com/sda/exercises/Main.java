package com.sda.exercises;

import com.sda.exercises.models.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Thread threadPerson = new Thread(person);
        threadPerson.start();

        Timer timer = new Timer(person.getAnimals());
        Thread threadTimer = new Thread(timer);
        threadTimer.start();
    }
}
