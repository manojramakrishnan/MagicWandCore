package com.magicwand.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicwand.entity.Registration;
import com.magicwand.service.UserService;

/**
 * 
 * @author Manoj Ramakrishnan
 * @implNote This is the user module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 05-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    /**
     * @apiNote This api method save the details of new user.
     * @param Registration Model object
     * @return an Object of Registration
     */
    @PostMapping("/register")
    public Registration register(@RequestBody Registration regn) {
        return service.register(regn);
    }
    
    /**
     * @apiNote This api method get the details of registered user.
     * @param Registration Model object
     * @return an Object of Registration
     */
    @GetMapping("/findByRegId/{regnId}")
    public Registration findByReg_Id(@PathVariable Integer regnId) {
    	return service.findByReg_Id(regnId);
    }
    
    /**
     * @apiNote This api method fetch all the registration details.
     * @param none
     * @return an list of Registrations
     */
    @GetMapping("/findAllRegistrations")
    public Iterable<Registration> findAllRegistrations() {
    	return service.findAllRegistrations();
    }


    }

