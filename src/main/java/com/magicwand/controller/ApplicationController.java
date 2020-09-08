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

import com.magicwand.entity.Application;
import com.magicwand.entity.Organization;
import com.magicwand.exceptions.ApplicationNotFoundException;
import com.magicwand.exceptions.UserNotFoundException;
import com.magicwand.service.ApplicationService;



/**
 * 
 * @author Anjali George
 * @implNote This is the application module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 12-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController
public class ApplicationController {
	@Autowired
    private ApplicationService service;

    /**
     * @apiNote This api method save the details of an application.
     * @param Application Model object
     * @return an Object of application 
     */
	@PostMapping("/addapplication")
    public Application application(@RequestBody Application app) {
        return service.application(app);
    }
	/**
     * @apiNote This api method get the data of a particular application Id.
     * @param Application Id Integer
     * @return an Object of application
     */
    @GetMapping("/getApplicationById/{appId}")
    public Optional<Application> findAppById(@PathVariable Integer appId) {
    	try {
    	return service.findByAppId(appId);
    	}
    	catch (ApplicationNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    }
    
    /**
     * @apiNote This api method get the data of all applications under a project.
     * @param projectId Integer
     * @return an List of application
     */
    @GetMapping("/getApplicationByProjectId/{project_id}")
    public List<Application> getApplicationByProjectId(@PathVariable Integer project_id) {
    	return service.getApplicationByProjectId(project_id);
    }

    /**
     * @apiNote This api method fetch all the application data.
     * @param none
     * @return an List of Application object
     */
    @GetMapping("/getAllApplications")
    public List<Application> findAllApplications() {
    	return service.findAllApplications();
    }
    
    /**
     * @apiNote This api method delete the data of a particular application Id.
     * @param Application Id Integer
     * @return the deleted application id
     */
    @DeleteMapping("/deleteapplication/{applicationId}")
        public String deleteApplication(@PathVariable int applicationId) {
            return service.deleteApplication(applicationId);
        }
    
	/**
     * @apiNote This api method delete the data of all application Id.
     * @param Application Id Integer List
     * @return the string
     */
	
    @DeleteMapping("/deleteApplicationsByIds/{application_idList}")
    public String deleteApplicationsByIds(List<Integer> application_idList)
    {
     return service.deleteApplicationsByIds( application_idList);
    }
}
