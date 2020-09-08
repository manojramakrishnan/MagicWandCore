package com.magicwand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicwand.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    
}