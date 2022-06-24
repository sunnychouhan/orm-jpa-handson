package com.jpa.handson.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.handson.config.PostgresDatabaseContainerInitializer;
import com.jpa.handson.entity.Employee;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addEmployee() throws Exception {
        Employee employee = Employee.builder().lastName("Alee")
                .firstName("Mack")
                .salary(10000)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String requestObj = objectMapper.writeValueAsString(employee);

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestObj))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk());
    }
}