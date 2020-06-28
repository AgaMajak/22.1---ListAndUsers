package com.exercises.ex22_1.data;

public class User {
    private String firstName;
    private String lastName;
    private Integer age;

    public User(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Użytkownik: " + firstName + " " + lastName + ", wiek: " + age + ";";
    }
}