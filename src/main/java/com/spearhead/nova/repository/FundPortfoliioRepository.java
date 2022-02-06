package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FundPortfolio;
@Repository

public interface FundPortfoliioRepository extends JpaRepository <FundPortfolio, Long> {
	
	

}
