package com.magicwand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicwand.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan,Integer> {
    
}