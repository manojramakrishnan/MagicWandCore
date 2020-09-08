package com.magicwand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicwand.entity.Registration;
import com.magicwand.repository.UserRepository;

/**
 * 
 * @author Manoj Ramakrishnan
 * @implNote This Service Class deals all the user related service processing.
 * @version 1.0
 * {@code done on: 05-08-2020}
 */

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    /**
     * @implNote this service method takes care of registering the new user details.
     * @param registration Model object
     * @return the saved Registration object with the generated registration id.
     * 
     */
    public Registration register(Registration regn) {
//    	regn.setPlan(regn.getPlan());
        return repository.save(regn);
    }
    
    /**
     * @implNote this service method takes care of fetching the registered user details based on registration id.
     * @param registration Model object
     * @return the list of Registration object of the passed registration id in the request.
     * 
     */
    //@Qualifier(value = "com.magicwand.repository.UserRepositoryImpl")
    public Registration findByReg_Id(Integer regnId) {
    	System.err.println("regnid in controller"+regnId);
    	return repository.findByReg_Id(regnId);
    }

    /**
     * @implNote this service method takes care of fetching the registered user details.
     * @param none
     * @return the list of Registration object.
     * 
     */
    
    public Iterable<Registration> findAllRegistrations() {
    	
    	return repository.findAll();
    }
   
}
