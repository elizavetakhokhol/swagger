package by.tms.swagger.controllers;

import by.tms.swagger.models.User;
import by.tms.swagger.service.UserService;
import by.tms.swagger.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@RequestBody List<User> users){
        userService.addAll(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getByUserName(@PathVariable("userName") String userName){
        User byUserName = userService.getByUserName(userName);
        if (byUserName != null) {
            return new ResponseEntity<>(byUserName, HttpStatus.OK);
        }
        return new ResponseEntity<>(byUserName, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<User> deleteByUserName(@PathVariable("userName") String userName){
        if (userService.deleteByUserName(userName)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
