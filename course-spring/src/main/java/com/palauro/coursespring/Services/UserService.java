package com.palauro.coursespring.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Repository.UserRepository;
import com.palauro.coursespring.Services.exceptions.DatabaseException;
import com.palauro.coursespring.Services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service // Registra "O que a classe é". Um serviço do Spring.
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByID(Long id) {
        Optional<User> obj = repository.findById(id); // Optional = classe em Java que representa um container que pode ou não conter um valor.
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Tenta dar o get, se não tiver lança uma exceção.
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        try{
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
       
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
