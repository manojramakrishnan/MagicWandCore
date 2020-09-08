package com.magicwand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicwand.entity.Child;

public interface ChildRepository extends JpaRepository<Child, Integer>{

}
