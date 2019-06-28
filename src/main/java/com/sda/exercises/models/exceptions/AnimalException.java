package com.sda.exercises.models.exceptions;

public class AnimalException extends Exception {
    private static final long serialVersionUID = 6685357619106110727L;
    private String message;

    public AnimalException(String message) {
        this.message = message;
    }

    public String toString() {
        return "AnimalException: " + this.message;
    }
}
