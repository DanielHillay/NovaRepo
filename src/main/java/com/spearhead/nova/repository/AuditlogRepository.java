package com.spearhead.nova.repository;

//import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.AuditLogs;

@Repository
public interface AuditlogRepository extends JpaRepository<AuditLogs, Long> {
	
	// Using Native query
		//@Query(value = "SELECT * FROM audit_logs WHERE created_at >= CURDATE()", nativeQuery = true)
	
	//JPA Query
	@Query(value = "from AuditLogs t where created_at BETWEEN :startDate AND :endDate")
	public List<AuditLogs> getAllBetweenDates(@Param("startDate")String startDate,@Param("endDate") String endDate);
	  
	//JPA Query
	@Query(value = "from AuditLogs t where created_at BETWEEN :startDate AND :endDate AND user_id = :userid")
	public List<AuditLogs> getAllBetweenDatesById(@Param("startDate")String startDate,@Param("endDate") String endDate, @Param("userid") Integer userid);

	
}
