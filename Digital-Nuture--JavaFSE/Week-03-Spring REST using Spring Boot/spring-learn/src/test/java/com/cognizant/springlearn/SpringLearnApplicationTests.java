package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController, "CountryController should be loaded in the context");
    }

    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));
        
        // Asserting exactly what was asked in the curriculum
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetCountryException() throws Exception {
        // Hitting the endpoint with an invalid country code
        ResultActions actions = mvc.perform(get("/countries/az"));
        
        // Expected to throw CountryNotFoundException which maps to 404 NOT_FOUND
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Country not found"));
    }

    @Test
    public void testUpdateEmployeeException() throws Exception {
        // Attempting to update an employee (ID 999) that does not exist in the mock DAO
        String requestJson = "{\"id\":999,\"name\":\"Ghost\",\"salary\":50000.0,\"permanent\":true,\"dateOfBirth\":\"10/10/1990\",\"department\":{\"id\":1,\"name\":\"IT\"},\"skills\":[{\"id\":1,\"name\":\"Java\"}]}";
        
        ResultActions actions = mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put("/employees")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(requestJson));
        
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Employee not found"));
    }
}
