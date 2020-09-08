package com.magicwand.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.magicwand.entity.Plan;
import com.magicwand.entity.Project;
import com.magicwand.exceptions.PlanNotFoundException;
import com.magicwand.exceptions.ProjectNotFoundException;
import com.magicwand.repository.ProjectRepository;


/**
 * 
 * @author Anjali George
 * @implNote This Service Class deals all the project related service processing.
 * @version 1.0
 * {@code done on:13-08-2020}
 */

@Service
public class ProjectService {
	 @Autowired
	    private ProjectRepository repository;

	    /**
	     * @implNote this service method takes care of adding the new project details.
	     * @param project Model object
	     * @return the saved project object with the generated project id.
	     * 
	     */
	    public Project project(Project prjt) {
//	    	regn.setPlan(regn.getPlan());
	        return repository.save(prjt);
	    }
	    /**
	     * @implNote this service method takes care of fetching the project details based on project id.
	     * @param project object
	     * @return the list of project object of the passed project id in the request.
	     * 
	     */
	    //@Qualifier(value = "com.magicwand.repository.UserRepositoryImpl")
	    public Optional<Project> findByProject_Id(Integer project_id)throws ProjectNotFoundException {
	    	//System.err.println("project in controller"+project_id);
	    	Optional<Project> project = repository.findById(project_id);
	    	if (!project.isPresent()) {
				throw new ProjectNotFoundException("Project Not found in project Repository");
			}
			return project;
	    }

	    /**
	     * @implNote this service method takes care of fetching the project details.
	     * @param none
	     * @return the list of project object.
	     * 
	     */
	    
	    public Iterable<Project> findAllProjects() {
	    	
	    	return repository.findAll();
	    }
	    
	    /**
	     * @implNote this service method takes care of fetching all projects based on organization id.
	     * @param Integer organization id
	     * @return the list of project object.
	     * 
	     */
	    
	    
		public List<Project> findProjectByOrganizationId(Integer organization_id) {
			// TODO Auto-generated method stub
			return repository.findProjectByOrganizationId(organization_id);
		}
		/**
	     * @implNote this service method takes care of deleting the project details of a particular project id.
	     * @param Project Model object
	     * @return the deleted project id in the request.
	     * 
	     */
	    public String deleteProject(int project_id) {
	        repository.deleteById(project_id);
	        return "Role removed !! " + project_id;
	    }
}
