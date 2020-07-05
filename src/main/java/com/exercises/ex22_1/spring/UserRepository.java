package com.exercises.ex22_1.spring;

import com.exercises.ex22_1.data.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> userList;

    public UserRepository(List<User> userList) {
        this.userList = userList;
        userList.add(new User("Anna", "Nowak", 22));
        userList.add(new User("Patryk", "Kowalski", 36));
        userList.add(new User("Dominika", "Zapolska", 30));
    }

    public void deleteUserFromList(User user) {
        userList.remove(user);
    }

    public void addUserToList(String firstname, String surname, Integer age) {
        userList.add(new User(firstname, surname, age));
    }

    @Override
    public String toString() {
        return userList.toString();
    }

    public List<User> searchInRepositoryForFirstName(String firstName) {
        return userList.stream()
                .filter((User user) -> firstName.equalsIgnoreCase(user.getFirstName()))
                .collect(Collectors.toList());
    }

    public List<User> searchInRepositoryForSurname(String surname) {
        return userList.stream()
                .filter((User user) -> surname.equalsIgnoreCase(user.getSurname()))
                .collect(Collectors.toList());
    }

    public List<User> searchInRepositoryForAge(Integer age) {
        return userList.stream()
                .filter((User user) -> age.equals(user.getAge()))
                .collect(Collectors.toList());
    }
}