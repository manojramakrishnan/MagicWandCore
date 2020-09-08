package com.magicwand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicwand.entity.Organization;


public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
    
}
