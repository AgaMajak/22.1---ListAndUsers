package com.exercises.ex22_1.spring;

import com.exercises.ex22_1.data.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserList {
    private List<User> userList;

    public UserList(List<User> userList) {
        this.userList = userList;
        userList.add(new User("Anna", "Nowak", 22));
        userList.add(new User("Patryk", "Kowalski", 36));
        userList.add(new User("Dominika", "Zapolska", 30));
    }

    public List<User> getUserList() {
        return userList;
    }
}