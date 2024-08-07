package com.hps.orderservice.repository;

import com.hps.orderservice.entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineItem,Long> {
}
