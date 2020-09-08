package com.magicwand.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.magicwand.entity.Project;
import com.magicwand.exceptions.PlanNotFoundException;
import com.magicwand.exceptions.ProjectNotFoundException;
import com.magicwand.service.ProjectService;


/**
 * 
 * @author Anjali George
 * @implNote This is the project module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 13-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController

public class ProjectController {
	@Autowired
    private ProjectService service;

    /**
     * @apiNote This api method save the details of a project.
     * @param Project Model object
     * @return an Object of Project
     */
    @PostMapping("/addproject")
    public Project project(@RequestBody Project prjt) {
        return service.project(prjt);
    }
    /**
     * @apiNote This api method get the details of the project.
     * @param project Model object
     * @return an Object of project.
     */
    @GetMapping("/findByProjectId/{project_id}")
    public Optional<Project> findByProject_Id(@PathVariable Integer project_id) {
    	try {
    	return service.findByProject_Id(project_id);
    	}
    	catch (ProjectNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    }
    
    /**
     * @apiNote This api method get the details of the all the projects by Organization Id
     * @param Integer organizationId
     * @return an List of project Objects.
     */
    @GetMapping("/findProjectByOrganizationId/{organization_id}")
    public List<Project> findProjectByOrganizationId(@PathVariable Integer organization_id) {
    	return service.findProjectByOrganizationId(organization_id);
    }
    
    /**
     * @apiNote This api method fetch all the project details.
     * @param none
     * @return a list of project.
     */
    @GetMapping("/findAllProjects")
    public Iterable<Project> findAllProjects() {
    	return service.findAllProjects();
    }
    /**
     * @apiNote This api method delete the data of a particular project Id.
     * @param Project Id Integer
     * @return the deleted project id
     */
    @DeleteMapping("/deleteprojectByID/{project_id}")
        public String deleteProject(@PathVariable int project_id) {
            return service.deleteProject(project_id);
        }

}
