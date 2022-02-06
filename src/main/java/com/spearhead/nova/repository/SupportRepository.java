package com.spearhead.nova.repository;

import javax.transaction.Transactional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.spearhead.nova.model.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {

	//JPA Query
	
	@Query("select s.status from Support s where supportId = :id") 
	public Support getStatusById(@Param("id") String supportId);
	
	@Modifying
	@Query("update Support s set s.status =1 where supportId = :id")
	@Transactional
	public void updateStatusById(@Param("id") Long supportId);
}
