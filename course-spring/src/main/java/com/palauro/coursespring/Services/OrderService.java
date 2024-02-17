package com.palauro.coursespring.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palauro.coursespring.Entities.Order;
import com.palauro.coursespring.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findByID(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
