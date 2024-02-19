package com.palauro.coursespring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.palauro.coursespring.Entities.OrderItem;
import com.palauro.coursespring.Entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}