package com.jpa.handson.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.handson.config.PostgresDatabaseContainerInitializer;
import com.jpa.handson.entity.Employee;
import com.jpa.handson.util.JsonUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerMockMvcIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional //This will rollback the table data after test completion
    void addEmployee() throws Exception {
        Employee employee = Employee.builder().lastName("Alee")
                .firstName("Mack")
                .salary(10002)
                .build();
        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(employee)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetAllEmployees() throws Exception {
        String contentAsString = mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("contentAsString = " + contentAsString);
    }
}