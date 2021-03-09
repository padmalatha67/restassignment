package com.springboot.restassignment.dao;

import com.springboot.restassignment.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
