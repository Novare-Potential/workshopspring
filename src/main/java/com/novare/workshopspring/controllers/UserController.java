package com.novare.workshopspring.controllers;

import com.novare.workshopspring.models.User;
import com.novare.workshopspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
/* /api/v1/users */
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable long id) {
        return userService.get(id);
    }

    @PostMapping
    User registerUser(@RequestBody User user){
        return userService.create(user);
    }

}
