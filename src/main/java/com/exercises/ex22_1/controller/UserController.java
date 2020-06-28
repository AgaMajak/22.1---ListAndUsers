package com.exercises.ex22_1.controller;

import com.exercises.ex22_1.data.User;
import com.exercises.ex22_1.spring.UserList;
import com.exercises.ex22_1.spring.UserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private final UserList userList;

    @Autowired
    public UserController(UserList userList) {
        this.userList = userList;
    }

    @RequestMapping("/users")
    @ResponseBody
    String printUsers() {
        return userList.getUserList().toString();
    }

    @RequestMapping("/delete")
    String delete() {
        return "/delete.html";
    }

    @RequestMapping("/search")
    String search() {
        return "/search.html";
    }

    @RequestMapping(value = "/addingUser", method = RequestMethod.POST)
    String add(@RequestParam String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        String blank = "";
        if (!firstName.equals(blank)) {
            userList.getUserList().add(new User(firstName, surname, age));
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }

    @RequestMapping(value = "/userdelete", method = RequestMethod.POST)
    @ResponseBody
    String deleteUser(@RequestParam(required = false) String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        List<User> users = UserOperation.deleteUsers(userList, firstName, surname, age);
        userList.setUserList(users);
        return "<h1>Użytkownik usunięty.</h1>";
    }

    @RequestMapping(value = "/usersearch", method = RequestMethod.POST)
    @ResponseBody
    String searchForUser(@RequestParam(required = false) String firstName, @RequestParam(required = false) String surname, @RequestParam(required = false) Integer age) {
        List<User> searchedUsers = UserOperation.searchForUsers(userList, firstName, surname, age);
        return "<h1>Wyszukani użytkownicy to:<h1><h2>" + searchedUsers.toString() + "</h2>";
    }
}