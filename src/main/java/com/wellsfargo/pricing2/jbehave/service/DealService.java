package com.wellsfargo.pricing2.jbehave.service;

import com.wellsfargo.pricing2.jbehave.model.Deal;
import com.wellsfargo.pricing2.jbehave.repo.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    @Autowired
    private DealRepo dealRepo;

    public Deal findDealById(Long dealId) {
        return dealRepo.findById(dealId).orElse(null);
    }

    public List<Deal> findAllDeals() {
        return dealRepo.findAll();
    }
}
