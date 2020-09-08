package com.magicwand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magicwand.entity.Application;


public interface ApplicationRepository extends JpaRepository<Application,Integer> {

	@Query("select a from Application a where a.project_id=:project_id")
	List<Application> getApplicationByProjectId(Integer project_id);
    
}
