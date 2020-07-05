package com.exercises.ex22_1.controller;

import com.exercises.ex22_1.data.User;
import com.exercises.ex22_1.spring.UserOperation;
import com.exercises.ex22_1.spring.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class UserController {
    private UserRepository userRepository;
    private UserOperation userOperation;

    @Autowired
    public UserController(UserRepository userRepository, UserOperation userOperation) {
        this.userRepository = userRepository;
        this.userOperation = userOperation;
    }

    @RequestMapping("/users")
    @ResponseBody
    String printUsers() {
        return userRepository.toString();
    }

    @RequestMapping(value = "/delete")
    String delete() {
        return "/delete.html";
    }

    @RequestMapping(value = "/search")
    String search() {
        return "/search.html";
    }

    @RequestMapping(value = "/addingUser")
    String add(@RequestParam String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        if (firstName != null && !firstName.isEmpty()) {
            userRepository.addUserToList(firstName, surname, age);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }

    @RequestMapping(value = "/userdelete")
    @ResponseBody
    String deleteUser(@RequestParam(required = false) String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        Set<User> usersToDelete = userOperation.searchForUsers(userRepository, firstName, surname, age);
        for (User user : usersToDelete) {
            userRepository.deleteUserFromList(user);
        }
        return "<h1>Użytkownik usunięty.</h1>";
    }

    @PostMapping(value = "/usersearch")
    @ResponseBody
    String searchForUser(@RequestParam(required = false) String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        Set<User> searchedUsers = userOperation.searchForUsers(userRepository, firstName, surname, age);
        return "<h1>Wyszukani użytkownicy to:<h1><h2>" + searchedUsers.toString() + "</h2>";
    }
}