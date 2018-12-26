package com.example.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findOneByLoginEmail(String loginEmail);
	public User findOneById(int id);
	
	@Modifying
	@Query("UPDATE User u SET latelyTime = :latelyTime, enabled = :enabled, accessCount = :accessCount WHERE id = :id")
	public void updateLogin(@Param("id") int id, @Param("latelyTime") Date latelyTime, 
			@Param("enabled") boolean enabled, @Param("accessCount") int accessCount);
	
	@Modifying
	@Query("UPDATE User u SET enabled = :enabled WHERE id = :id")
	public void updateLogout(@Param("id") int id, @Param("enabled") boolean enabled);
	
}
