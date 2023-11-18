package com.example.zuzex.services;

import com.example.zuzex.model.Resident;
import com.example.zuzex.model.User;
import com.example.zuzex.model.UserUpdateDTO;
import com.example.zuzex.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void update(int id, UserUpdateDTO user) {
        repository.update(id, user);
    }

    public User getById(int id) {
        return repository.getById(id);
    }

    public void save(User user) {
        repository.save(user);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void addResident(int id, Resident resident) {
        repository.addResident(id,resident);
    }
}
