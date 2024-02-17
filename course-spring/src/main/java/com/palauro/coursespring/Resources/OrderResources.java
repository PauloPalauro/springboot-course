package com.palauro.coursespring.Resources;

import com.palauro.coursespring.Entities.Order;
import com.palauro.coursespring.Services.OrderService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController 
@RequestMapping(value = "/orders") 
public class OrderResources {

    @Autowired
    private OrderService service;

    @GetMapping()
    public ResponseEntity<List<Order>> findAll() { 
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list); 
    }

    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) { 
        Order obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
}
