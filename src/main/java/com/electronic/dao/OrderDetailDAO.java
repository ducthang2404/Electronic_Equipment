package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

}
