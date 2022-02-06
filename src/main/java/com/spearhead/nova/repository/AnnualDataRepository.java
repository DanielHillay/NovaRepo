package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.AnnualData;
@Repository
public interface AnnualDataRepository extends JpaRepository<AnnualData, Long> {

}
