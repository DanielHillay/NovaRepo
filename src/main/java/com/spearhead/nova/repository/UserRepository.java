package com.spearhead.nova.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String username);

	Optional<User> findByUserId(Long adminId);
	Optional<User> findByCustomerId(Long adminId);
	
	@Modifying
	@Query("update User u set u.userStatus =1 where userId = :id")
	@Transactional
	public void updateStatusById(@Param("id") Long userId);

}
