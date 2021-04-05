package com.wellsfargo.pricing2.jbehave.repo;

import com.wellsfargo.pricing2.jbehave.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepo extends JpaRepository<Deal, Long> {
}
