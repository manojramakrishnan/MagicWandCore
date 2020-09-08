package com.magicwand.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.magicwand.entity.Registration;
import com.magicwand.entity.User;
import com.magicwand.exceptions.UserExistsException;
import com.magicwand.exceptions.UserNotFoundException;
import com.magicwand.service.AdminService;
import com.magicwand.service.UserService;
/**
 * 
 * @author Anjali George
 * @implNote This is the Admin module controller which is used for Approve or Reject the registered user and stores the real time data of a user.
 * @version 1.0
 * {@code done on: 06-08-2020}
 *
 */
@CrossOrigin(origins = "http://localhost:9192")
@RestController

public class AdminController {
	@Autowired
    private AdminService service;
	

	private Registration registration;
	
	@Autowired
	private UserService uservice;
	
	

    /**
     * @apiNote This api method save the real time details of a user.
     * @param User Model object
     * @return an Object of User
     */
//    @PostMapping("/approveOrRejectUser")
//    public User user(@RequestBody User usr) {
//    	if (usr.getStatus().equalsIgnoreCase("approved")){
//    		registration = uservice.findByReg_Id(usr.getRegId());
//    		usr.setUserName(registration.getUserName());
//    		usr.setPassword(registration.getPassword());
//    		usr.setConfirmPassword(registration.getConfirmPassword());
//    	}
//        return service.user(usr);
//    }
    
    @PostMapping("/approveOrRejectUser")
    public ResponseEntity<Void> user(@RequestBody User usr, UriComponentsBuilder builder) throws UserExistsException {
    	if (usr.getStatus().equalsIgnoreCase("approved")){
    		registration = uservice.findByReg_Id(usr.getRegId());
    		usr.setUserName(registration.getUserName());
    		usr.setPassword(registration.getPassword());
    		usr.setConfirmPassword(registration.getConfirmPassword());
    	}
    	service.user(usr);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/getusers/{id}").buildAndExpand(usr.getUid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        
    }
    
    /**
     * @apiNote This api method get the user by uid.
     * @param Integer uid
     * @return an Object of User
     */
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
    	try {
    		return service.getUserById(id);
    	}
    	catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
    	
    }
    
    /**
     * @apiNote This api method get all the approved users.
     * @param status String
     * @return an Object of User List
     */
    @GetMapping("/getAllUsersByStatus/{status}")
    public List<User> getAllUsersByStatus(@PathVariable String status) {
    	return service.getAllUsersByStatus(status);
    }
    
    /**
     * @apiNote This api method get all the users.
     * @param none
     * @return an Object of User List
     */
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
    	return service.getAllUsers();
    }
    
    /**
     * @apiNote This api method update the user information.
     * @param User Object Model
     * @return an Object of User
     */
    @PutMapping("/userDetailsupdate")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }
    /**
     * @apiNote This api method delete the data of a particular user Id.
     * @param User Id Integer
     * @return the deleted user id
     */
    @DeleteMapping("/deleteUserById/{uid}")
        public String deleteUser(@PathVariable int uid) {
            return service.deleteUser(uid);
        }
    }


