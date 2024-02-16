package com.palauro.coursespring.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Repository.UserRepository;


@Service // Registra "O que a classe é". Um serviço do Spring.
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByID(Long id) {
        Optional<User> obj = repository.findById(id); // Optional = classe em Java que representa um container que pode ou não conter um valor.
        return obj.get();
    }
}
