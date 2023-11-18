package com.example.zuzex.controllers;

import com.example.zuzex.model.Home;
import com.example.zuzex.model.HomeUpdateDTO;
import com.example.zuzex.services.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;

    @PostMapping ("/{id}")
    public void update(@PathVariable int id, @RequestBody HomeUpdateDTO home) {
        service.update(id, home);
    }

    @GetMapping("/{id}")
    public Home getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Home home) {
        service.save(home);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }
}
