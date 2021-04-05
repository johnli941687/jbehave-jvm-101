package com.wellsfargo.pricing2.jbehave.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.pricing2.jbehave.AbstractSteps;
import com.wellsfargo.pricing2.jbehave.model.Deal;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

@Component
public class DealSteps extends AbstractSteps {
    private Deal deal;
    private List<Deal> deals;
    private final String BASE_URL = "/deal/";

    @Autowired
    private ObjectMapper objectMapper;

    @Given("user request for all deals")
    public void userRequestAllLoans() throws Exception {
        MockHttpServletResponse response = getResponse(BASE_URL + "all");
        deals = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Deal>>() {
        });
    }

    @Then("there should be following deals $deals")
    public void userShouldSeeAllLoans(ExamplesTable deals) {
        List<Deal> expectedDeals = deals.getRowsAs(Deal.class);

        List<Long> expectedEdns = expectedDeals.stream().map(Deal::getEdn).collect(toList());
        List<Long> actualEdns = this.deals.stream().map(Deal::getEdn).collect(toList());

        assertEquals(expectedEdns, actualEdns);
    }

    @Given("user requests for loan ${dealId}")
    public void userRequestLoan(Long dealId) throws Exception {
        MockHttpServletResponse response = getResponse(BASE_URL + dealId);
        deal = objectMapper.readValue(response.getContentAsString(), Deal.class);
    }

    @Then("loan with edn ${edn} should be returned")
    public void userShouldGetLoan(Long edn) {
        assertEquals(edn, deal.getEdn());
    }
}
