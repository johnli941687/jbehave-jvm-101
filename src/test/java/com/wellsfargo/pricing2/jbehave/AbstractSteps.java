package com.wellsfargo.pricing2.jbehave;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public abstract class AbstractSteps {
    @Autowired
    private MockMvc mockMvc;

    protected MockHttpServletResponse getResponse(String url) throws Exception {
        return mockMvc.perform(get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse();
    }
}
