package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.Loans;
@Repository
public interface LoanRepository extends JpaRepository <Loans, Long> {

}
