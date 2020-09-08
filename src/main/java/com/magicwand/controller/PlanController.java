package com.magicwand.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.magicwand.entity.Plan;
import com.magicwand.entity.Registration;
import com.magicwand.exceptions.OrganizationNotFoundException;
import com.magicwand.exceptions.PlanNotFoundException;
import com.magicwand.service.PlanService;

/**
 * 
 * @author Anjali George
 * @implNote This is the Plan module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 07-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController

public class PlanController {
	@Autowired
    private PlanService service;

    /**
     * @apiNote This api method save the details of different membership plans available in the application.
     * @param Plan Model object
     * @return an Object of Plan
     */
    @PostMapping("/saveplan")
    public Plan plan(@RequestBody Plan pln) {
        return service.plan(pln);
    }
    
    /**
     * @apiNote This api method get the data of a particular plan Id.
     * @param Plan Id Integer
     * @return an Object of Plan
     */
    @GetMapping("/findByPlanId/{planId}")
    public Optional<Plan> findByReg_Id(@PathVariable Integer planId) {
    	try {
    	return service.findByPlanId(planId);
    	}
    	catch (PlanNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    }

    /**
     * @apiNote This api method fetch all the plan data.
     * @param none
     * @return an List of Plan object
     */
    @GetMapping("/findAllPlans")
    public List<Plan> findAllPlans() {
    	return service.findAllPlans();
    }

    

}
