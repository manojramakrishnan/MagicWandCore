package com.magicwand.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.magicwand.entity.Usertype;

public interface UsertypeRepository extends JpaRepository<Usertype,Integer> {
    
}