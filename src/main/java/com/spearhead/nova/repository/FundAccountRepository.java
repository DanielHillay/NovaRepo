package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FundAccount;
@Repository

public interface FundAccountRepository extends JpaRepository<FundAccount, Long> {

}
