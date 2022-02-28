package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.Provider;

public interface ProviderDAO extends JpaRepository<Provider, Integer> {

}
