package com.magicwand.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magicwand.entity.User;

public interface AdminRepository extends JpaRepository<User,Integer> {

	@Query("select u from User u,Registration r where r.id=u.regId and u.status=:status")
	List<User> getAllUsersByStatus(String status);

	User findByUserName(String username);
    
}
