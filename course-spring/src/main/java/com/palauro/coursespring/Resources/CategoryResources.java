package com.palauro.coursespring.Resources;

import com.palauro.coursespring.Entities.Category;
import com.palauro.coursespring.Services.CategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/category")
public class CategoryResources {

    @Autowired
    private CategoryService service;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
}
