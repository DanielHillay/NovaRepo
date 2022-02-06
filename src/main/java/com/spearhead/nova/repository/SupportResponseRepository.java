package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.SupportResponse;

@Repository
public interface SupportResponseRepository extends JpaRepository<SupportResponse, Long>  {

}
