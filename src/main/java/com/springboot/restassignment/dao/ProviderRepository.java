package com.springboot.restassignment.dao;

import com.springboot.restassignment.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
