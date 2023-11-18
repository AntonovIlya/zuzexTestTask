package com.example.zuzex.services;

import com.example.zuzex.model.Home;
import com.example.zuzex.model.HomeUpdateDTO;
import com.example.zuzex.repositories.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository repository;

    public void update(int id, HomeUpdateDTO home) {
        repository.update(id,home);
    }

    public Home getById(int id) {
        return repository.getById(id);
    }

    public void save(Home home) {
        repository.save(home);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
