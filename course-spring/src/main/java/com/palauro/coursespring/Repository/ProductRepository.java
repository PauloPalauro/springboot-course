package com.palauro.coursespring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palauro.coursespring.Entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {


}