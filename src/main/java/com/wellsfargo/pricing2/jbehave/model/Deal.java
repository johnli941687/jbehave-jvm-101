package com.wellsfargo.pricing2.jbehave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEAL", schema = "DEAL")
public class Deal {
    @Id
    @Column(name = "DEAL_ID")
    private Long dealId;
    @Column(name = "ENTERPRISE_DEAL_ID")
    private Long edn;
    @Column(name = "APPLIED_SCENARIO_ID")
    private Long currentAppliedScenarioId;

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public Long getEdn() {
        return edn;
    }

    public void setEdn(Long edn) {
        this.edn = edn;
    }

    public Long getCurrentAppliedScenarioId() {
        return currentAppliedScenarioId;
    }

    public void setCurrentAppliedScenarioId(Long currentAppliedScenarioId) {
        this.currentAppliedScenarioId = currentAppliedScenarioId;
    }
}
