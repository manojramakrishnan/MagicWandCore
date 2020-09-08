package com.magicwand.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.magicwand.entity.Team;

public interface TeamRepository extends CrudRepository<Team,Integer> {
	
	@Query("select t from Team t where t.team_name=:teamName")
	Iterable<Team> findByTeamName(String teamName);
    
}
