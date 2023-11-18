package com.example.zuzex.controllers;

import com.example.zuzex.model.Resident;
import com.example.zuzex.model.User;
import com.example.zuzex.model.UserUpdateDTO;
import com.example.zuzex.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserUpdateDTO user) {
        service.update(id, user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        service.save(user);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }

    @PostMapping("/{id}/resident")
    public void addResident(@PathVariable int id, @RequestBody Resident resident) {
        service.addResident(id, resident);
    }
}
