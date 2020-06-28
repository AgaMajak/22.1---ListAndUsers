package com.exercises.ex22_1.spring;

import com.exercises.ex22_1.data.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserOperation {

    public static List<User> deleteUsers(UserList userList, String firstname, String surname, Integer age) {
        return userList.getUserList().stream()
                .filter((User user) -> !firstname.equalsIgnoreCase(user.getFirstName()))
                .filter((User user) -> !surname.equalsIgnoreCase(user.getSurname()))
                .filter((User user) -> !age.equals(user.getAge()))
                .collect(Collectors.toList());
    }

    public static List<User> searchForUsers(UserList userList, String firstname, String surname, Integer age) {
        return userList.getUserList().stream()
                .filter((User user) -> firstname.equalsIgnoreCase(user.getFirstName()))
                .filter((User user) -> surname.equalsIgnoreCase(user.getSurname()))
                .filter((User user) -> age.equals(user.getAge()))
                .collect(Collectors.toList());
    }
}