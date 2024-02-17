package com.palauro.coursespring.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.coursespring.Entities.Product;
import com.palauro.coursespring.Repository.ProductRepository;



@Service // Registra "O que a classe é". Um serviço do Spring.
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findByID(Long id) {
        Optional<Product> obj = repository.findById(id); // Optional = classe em Java que representa um container que pode ou não conter um valor.
        return obj.get();
    }
}
