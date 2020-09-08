package com.magicwand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.magicwand.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    
	@Query("select p from Project p where p.project_id=:project_id")
	Project findByProject_Id(Integer project_id);
    
	@Query("select p from Project p where p.organization_id=:organization_id")
	List<Project> findProjectByOrganizationId(Integer organization_id);
}
