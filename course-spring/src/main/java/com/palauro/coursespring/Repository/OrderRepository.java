package com.palauro.coursespring.Repository;

import com.palauro.coursespring.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {


}