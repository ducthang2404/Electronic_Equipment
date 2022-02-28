package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.Staff;

public interface StaffDAO extends JpaRepository<Staff, Integer> {

}
