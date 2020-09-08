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

import com.magicwand.entity.Role;
import com.magicwand.entity.Usertype;
import com.magicwand.exceptions.RoleNotFoundException;
import com.magicwand.exceptions.UsertypeNotFoundException;
import com.magicwand.service.UsertypeService;

/**
 * 
 * @author Anjali George
 * @implNote This is the usertype module controller which redirect the incoming http service requests to 
 * the service layer.
 * @version 1.0
 * {@code done on: 07-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController
public class UsertypeController {
	@Autowired
    private UsertypeService service;

    /**
     * @apiNote This api method save the details of roles of different users.
     * @param Usertype Model object
     * @return an Object of Usertype
     */
    @PostMapping("/saveusertype")
    public Usertype usertype(@RequestBody Usertype usrtype) {
        return service.usertype(usrtype);
    }
    /**
     * @apiNote This api method get the data of a particular usertype Id.
     * @param Usertype Id Integer
     * @return an Object of Usertype
     */
    @GetMapping("/getUserTypeById/{usertypeId}")
    public Optional<Usertype> findUsertypeById(@PathVariable Integer usertypeId) {
    	try {
    	return service.findByUsertypeId(usertypeId);
    	}
    	catch (UsertypeNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    }

    /**
     * @apiNote This api method fetch all the usertype data.
     * @param none
     * @return an List of Usertype object
     */
    @GetMapping("/getAllUserTypes")
    public List<Usertype> findAllUsertypes() {
    	return service.findAllUsertypes();
    }

    
    /**
     * @apiNote This api method delete the data of a particular usertype Id.
     * @param Usertype Id Integer
     * @return the Id of deleted Usertype
     */
    @DeleteMapping("/deleteusertype/{usertypeId}")
    public String deleteUsertype(@PathVariable int usertypeId) {
        return service.deleteUsertype(usertypeId);
    }


}
