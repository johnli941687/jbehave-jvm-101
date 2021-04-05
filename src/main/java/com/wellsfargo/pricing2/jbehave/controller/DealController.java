package com.wellsfargo.pricing2.jbehave.controller;

import com.wellsfargo.pricing2.jbehave.model.Deal;
import com.wellsfargo.pricing2.jbehave.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deal/")
public class DealController {
    @Autowired
    private DealService dealService;

    @GetMapping("{dealId}")
    public Deal getDealById(@PathVariable Long dealId) {
        return dealService.findDealById(dealId);
    }

    @GetMapping("all")
    public List<Deal> getAllDeals() {
        return dealService.findAllDeals();
    }
}

