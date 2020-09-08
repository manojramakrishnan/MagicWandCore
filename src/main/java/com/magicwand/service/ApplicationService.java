package com.magicwand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicwand.entity.Application;
import com.magicwand.entity.Role;
import com.magicwand.entity.User;
import com.magicwand.exceptions.ApplicationNotFoundException;
import com.magicwand.exceptions.UserNotFoundException;
import com.magicwand.repository.ApplicationRepository;
import com.magicwand.repository.RoleRepository;

/**
 * 
 * @author Anjali George
 * @implNote This Service Class deals with different applications used in a
 *           project.
 * @version 1.0 {@code done on: 12-08-2020}
 */

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository repository;

	/**
	 * @implNote this service method takes care of different applications.
	 * @param application Model object
	 * @return the saved Application object with the application id.
	 * 
	 */
	public Application application(Application app) {
		return repository.save(app);
	}

	/**
	 * @implNote this service method takes care of fetching the application details
	 *           of a particular application id.
	 * @param Application Model object
	 * @return the list of Application object of the passed application id in the
	 *         request.
	 * 
	 */

	public Optional<Application> findByAppId(Integer appId) throws ApplicationNotFoundException {
		Optional<Application> application = repository.findById(appId);
		

		if (!application.isPresent()) {
			throw new ApplicationNotFoundException("Application Not found in application Repository");
		}
		//return repository.findById(appId);
		return application;
	}
		
	

	/**
	 * @implNote this service method takes care of fetching all the application
	 *           details.
	 * @param none
	 * @return the list of all application data.
	 * 
	 */
	public List<Application> findAllApplications() {
		return repository.findAll();
	}

	/**
	 * @implNote this service method takes care of fetching all the applications
	 *           based on projectid.
	 * @param Integer projectid
	 * @return the list of all application data.
	 * 
	 */
	public List<Application> getApplicationByProjectId(Integer project_id) {
		// TODO Auto-generated method stub
		return repository.getApplicationByProjectId(project_id);
	}

	/**
	 * @implNote this service method takes care of deleting the application details
	 *           of a particular application id.
	 * @param Application Model object
	 * @return the deleted application id in the request.
	 * 
	 */
	public String deleteApplication(int applicationId) {

		repository.deleteById(applicationId);
		return "Application removed !! " + applicationId;
	}

	/**
	 * @implNote this service method takes care of deleting all the applications as
	 *           mentioned in parameter list.
	 * @param Application Model object
	 * @return the deleted application id in the request.
	 * 
	 */
	public String deleteApplicationsByIds(List<Integer> application_idList) {
		for (Integer applicationId : application_idList) {
			repository.deleteById(applicationId);
		}
		return "Applications removed !! ";
	}

}
