package com.bhavika.budget_brains.repository;

import com.bhavika.budget_brains.entity.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads,Long> {
}
