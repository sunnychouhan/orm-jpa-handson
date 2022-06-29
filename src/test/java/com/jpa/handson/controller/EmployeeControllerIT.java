package com.jpa.handson.controller;

import com.jpa.handson.config.PostgresDatabaseContainerInitializer;
import com.jpa.handson.entity.Employee;
import com.jpa.handson.repository.DbCleanUp;
import com.jpa.handson.util.JsonUtil;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
@TestMethodOrder(MethodOrderer.MethodName.class)
@ActiveProfiles("test")
public class EmployeeControllerIT {

    public static final String HTTP_LOCALHOST = "http://localhost:";
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    DbCleanUp dbCleanUp;

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void beforeAllTest() {
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter(),
                new ErrorLoggingFilter());
    }

    @AfterEach
    public void afterEachTest(){
        dbCleanUp.execute();
    }


    @Test
    public void shouldCreateEmployee() {
        Employee employee = Employee.builder().lastName("Alee")
                .firstName("Mack")
                .salary(10000)
                .build();
        Employee emp = given()
                .contentType("application/json")
                .body(JsonUtil.toJson(employee))
                .post(HTTP_LOCALHOST + port + "/employee")
                .then()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("firstName", Matchers.is("Mack"))
                .body("salary", Matchers.is(10000))
                .extract()
                .as(Employee.class);
    }

    @Test
    public void shouldGetEmployee() {
        Object as = given()
                .get(HTTP_LOCALHOST + port + "/employee")
                .then()
                .statusCode(200)
                .extract()
                .as(List.class);
        System.out.println("as = " + as);
    }

}
