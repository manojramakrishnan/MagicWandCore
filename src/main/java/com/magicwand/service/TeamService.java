package com.magicwand.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicwand.entity.Team;
import com.magicwand.repository.TeamRepository;


/**
 * 
 * @author Anjali George
 * @implNote This Service Class deals with different teams of the application.
 * @version 1.0
 * {@code done on: 13-08-2020}
 */

@Service
public class TeamService {
	@Autowired
    private TeamRepository repository;

    /**
     * @implNote this service method takes care of different teams of the application.
     * @param team Model object
     * @return the saved team object with the team id.
     * 
     */
    public Iterable<Team> team(Team tm) {
    	
    	List<Integer> userIds = tm.getUserIds();
    	List<Integer> existUserIds = new ArrayList<Integer>();
    	List<Integer> newUserIds = new ArrayList<Integer>();
    	Iterable<Team> existingTeam = repository.findByTeamName(tm.getTeam_name());
    	if(null != existingTeam) {
    		Integer userId=0;
    	for (Team team : existingTeam) {
    		userId = team.getUserId();
    		existUserIds.add(userId);
		}
    	
    	
		for(Integer i: userIds)
		{
			if(!existUserIds.contains(i))
			{
				newUserIds.add(i);
			}
		}
		
    	Team newTeam;
    	List<Team> newTeamList = new ArrayList<Team>();
    	for (Integer integer : newUserIds) {
    		newTeam = new Team();
    		newTeam.setTeam_name(tm.getTeam_name());
			newTeam.setUserId(integer);
			newTeam.setCreated_by(tm.getCreated_by());
			newTeam.setCreated_dttm(tm.getCreated_dttm());
			newTeam.setModified_by(tm.getModified_by());
			newTeam.setModified_dttm(tm.getModified_dttm());
			newTeamList.add(newTeam);
		}
    	return repository.saveAll(newTeamList);
    	}
    	else {
    		Team newTeam;
        	List<Team> newTeamList = new ArrayList<Team>();
        	for (Integer integer : userIds) {
        		newTeam = new Team();
        		newTeam.setTeam_name(tm.getTeam_name());
    			newTeam.setUserId(integer);
    			newTeam.setCreated_by(tm.getCreated_by());
    			newTeam.setCreated_dttm(tm.getCreated_dttm());
    			newTeam.setModified_by(tm.getModified_by());
    			newTeam.setModified_dttm(tm.getModified_dttm());
    			newTeamList.add(newTeam);
    	}
        	return repository.saveAll(newTeamList);
    	}
    	
        
    }
    /**
     * @implNote this service method takes care of fetching the team details of a particular team id.
     * @param Team Model object
     * @return the list of Team object of the passed team id in the request.
     * 
     */
    
    public Iterable<Team> findTeamByName(String teamName) {
    	return repository.findByTeamName(teamName);
    }
    
    public Optional<Team> findTeamById(Integer userId) {
    	return repository.findById(userId);
    }
    
	/**
     * @implNote this service method takes care of fetching all the team details.
     * @param none
     * @return the list of all team data.
     * 
     */
    public Iterable<Team> findAllTeams() {
    	return repository.findAll();
    }
    /**
     * @implNote this service method takes care of deleting the user details from team table from of a particular team name.
     * @param team Model object
     * @return the deleted user id in the request.
     * 
     */
    public String deleteUserInTeamByUid(int userId) {
    	repository.deleteById(userId);
        return "User removed !! " + userId;
    }
   
}
