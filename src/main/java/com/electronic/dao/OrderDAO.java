package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

}
