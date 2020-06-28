package com.exercises.ex22_1.controller;

import com.exercises.ex22_1.data.User;
import com.exercises.ex22_1.spring.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}