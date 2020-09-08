package com.magicwand.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.magicwand.entity.Registration;

public interface UserRepository extends CrudRepository<Registration,Integer> {
	
	@Query("select r from Registration r, Plan p where p.plan_id=r.planid and r.id=:id")
	public Registration findByReg_Id(Integer id); 
}

