package com.exercises.ex22_1.spring;

import com.exercises.ex22_1.data.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserOperation {

    private static boolean isFirstNameNullOrEmpty(String firstname) {
        return !firstname.isEmpty() && firstname != null;
    }

    private static boolean isSurnameNullOrEmpty(String surname) {
        return !surname.isEmpty() && surname != null;
    }

    private static boolean isAgeNull(Integer age) {
        return age != null;
    }

    public Set<User> searchForUsers(UserRepository userRepository, String firstname, String surname, Integer age) {
        Set<User> searchedSet = new HashSet<>();
        addingUsersToSet(userRepository, firstname, surname, age, searchedSet);
        deletingFromSet(firstname, surname, age, searchedSet);
        return searchedSet;
    }

    private void addingUsersToSet(UserRepository userRepository, String firstname, String surname, Integer age, Set<User> users) {
        if (isFirstNameNullOrEmpty(firstname)) {
            users.addAll(userRepository.searchInRepositoryForFirstName(firstname));
        }
        if (isSurnameNullOrEmpty(surname)) {
            users.addAll(userRepository.searchInRepositoryForSurname(surname));
        }
        if (isAgeNull(age)) {
            users.addAll(userRepository.searchInRepositoryForAge(age));
        }
    }

    private void deletingFromSet(String firstname, String surname, Integer age, Set<User> users) {
        if (isFirstNameNullOrEmpty(firstname)) {
            users.removeIf(user -> !user.getFirstName().equals(firstname));
        }
        if (isSurnameNullOrEmpty(surname)) {
            users.removeIf(user -> !user.getSurname().equals(surname));
        }
        if (isAgeNull(age)) {
            users.removeIf(user -> !user.getAge().equals(age));
        }
    }
}