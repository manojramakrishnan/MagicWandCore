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

import com.magicwand.entity.Organization;
import com.magicwand.entity.Role;
import com.magicwand.exceptions.ApplicationNotFoundException;
import com.magicwand.exceptions.OrganizationNotFoundException;
import com.magicwand.service.OrganizationService;
import com.magicwand.service.RoleService;

/**
 * 
 * @author Anjali George
 * @implNote This is the organization module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 12-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController
public class OrganizationController {
	@Autowired
    private OrganizationService service;

    /**
     * @apiNote This api method save the details of an organization.
     * @param Organization Model object
     * @return an Object of organization
     */
	@PostMapping("/addorganization")
    public Organization organization(@RequestBody Organization org) {
        return service.organization(org);
    }
	/**
     * @apiNote This api method get the data of a particular organization Id.
     * @param Organization Id Integer
     * @return an Object of organization
     */
    @GetMapping("/getOrgById/{orgId}")
    public Optional<Organization> findOrgById(@PathVariable Integer orgId) {
    	try {
    	return service.findByOrgId(orgId);
    	}
    	catch (OrganizationNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    }

    /**
     * @apiNote This api method fetch all the organization's data.
     * @param none
     * @return an List of Organization object
     */
    @GetMapping("/getAllOrganizations")
    public List<Organization> findAllOrganizations() {
    	return service.findAllOrganizations();
    }
    /**
     * @apiNote This api method delete the data of a particular organization Id.
     * @param Organization Id Integer
     * @return the deleted organization id
     */
    @DeleteMapping("/deleteorganizationByID/{orgId}")
        public String deleteOrganization(@PathVariable int orgId) {
            return service.deleteOrganization(orgId);
        }
}

