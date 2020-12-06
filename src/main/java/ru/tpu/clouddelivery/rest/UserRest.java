package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.User;
import ru.tpu.clouddelivery.service.UserService;

@RestController
@RequestMapping(value = "api/user")
public class UserRest {

    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") User userFromDb, @RequestBody User newUser) {
        return userService.updateUser(userFromDb, newUser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User userFromDB) {
        userService.deleteUser(userFromDB);
    }
}
