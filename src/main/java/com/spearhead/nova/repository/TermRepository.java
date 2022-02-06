package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.Terms;

@Repository
public interface TermRepository extends JpaRepository<Terms, Long> {

}
