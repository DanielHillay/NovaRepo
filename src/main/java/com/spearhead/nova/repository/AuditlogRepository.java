package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spearhead.nova.model.AuditLogs;


public interface AuditlogRepository extends JpaRepository<AuditLogs, Long> {

}
