package com.exercises.ex22_1.data;

public class User {
    private String firstName;
    private String surname;
    private Integer age;

    public User(String firstName, String surname, Integer age) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Użytkownik: " + firstName + " " + surname + ", wiek: " + age + ";";
    }
}