package com.springboot.restassignment.dao;

import com.springboot.restassignment.entity.Provider;
import com.springboot.restassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
