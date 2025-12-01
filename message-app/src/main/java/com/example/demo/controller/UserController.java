package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    // curl: GET /users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }

    // curl: POST /users  (application/json)
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.accepted().build();
    }

    // curl: GET /users/{index}
    @GetMapping("/{index}")
    public ResponseEntity<User> getUser(@PathVariable int index) {
        return ResponseEntity.ok(users.get(index));
    }

    // curl: DELETE /users/{index}
    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deleteUser(@PathVariable int index) {
        users.remove(index);
        return ResponseEntity.noContent().build();
    }

    // curl: PUT /users/{index}/age  (body: number as JSON or plain text)
    @PutMapping("/{index}/age")
    public ResponseEntity<Void> updateAge(@PathVariable int index, @RequestBody Integer age) {
        User u = users.get(index);
        u.setAge(age);
        return ResponseEntity.accepted().build();
    }
}
