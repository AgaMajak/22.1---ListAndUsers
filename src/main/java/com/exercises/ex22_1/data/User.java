package com.exercises.ex22_1.data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, age);
    }
}