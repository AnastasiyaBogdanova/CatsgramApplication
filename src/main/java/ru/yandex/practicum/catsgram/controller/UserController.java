package ru.yandex.practicum.catsgram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User update(@RequestBody User newUser) {
        return userService.updateUser(newUser);
    }

    @GetMapping("/user/{userMail}")
    public User getUser(@PathVariable("userMail") String userMail) {
        return userService.findUserByEmail(userMail);
    }

}
