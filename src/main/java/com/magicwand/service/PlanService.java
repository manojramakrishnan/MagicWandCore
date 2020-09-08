package com.magicwand.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicwand.entity.Organization;
import com.magicwand.entity.Plan;
import com.magicwand.entity.Registration;
import com.magicwand.exceptions.OrganizationNotFoundException;
import com.magicwand.exceptions.PlanNotFoundException;
import com.magicwand.repository.PlanRepository;

/**
 * 
 * @author Anjali George
 * @implNote This Service Class deals with different membership plans availble in the application. Plan types include basic plan, advanced and premium.
 * @version 1.0
 * {@code done on: 07-08-2020}
 */

@Service

public class PlanService {
	 @Autowired
	    private PlanRepository repository;

	    /**
	     * @implNote this service method takes care of different membership plans available in the application
	     * @param plan Model object
	     * @return the saved plan object with the plan id.
	     * 
	     */
	    public Plan plan(Plan pln) {
	        return repository.save(pln);
	    }

		/**
     * @implNote this service method takes care of fetching the plan details of a particular plan id.
     * @param Plan Model object
     * @return the list of Plan object of the passed plan id in the request.
     * 
     */
    
    public Optional<Plan> findByPlanId(Integer planId)throws PlanNotFoundException {
    	Optional<Plan> plan = repository.findById(planId);
    	if (!plan.isPresent()) {
			throw new PlanNotFoundException("Plan Not found in plan Repository");
		}
		return plan;
    }
    
	/**
     * @implNote this service method takes care of fetching all the plan details.
     * @param none
     * @return the list of all Plans data.
     * 
     */
    public List<Plan> findAllPlans() {
    	return repository.findAll();
    }

}
