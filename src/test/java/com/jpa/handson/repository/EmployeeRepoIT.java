package com.jpa.handson.repository;

import com.jpa.handson.config.PostgresDatabaseContainerInitializer;
import com.jpa.handson.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepoIT {
/*    private static final PostgreSQLContainer<?> sqlContainer =
            new PostgreSQLContainer<>("postgres:14-alpine");

    @BeforeAll
    static void beforeAll() {
        //https://stackoverflow.com/questions/53078306/populate-a-database-with-testcontainers-in-a-springboot-integration-test
        sqlContainer.withInitScript("scripts/dbschema.sql");
        sqlContainer.start();
    }

    @AfterAll
    static void afterAll() {
        sqlContainer.stop();
    }

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", sqlContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", sqlContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", sqlContainer::getPassword);
    }*/

    @Autowired
    private EmployeeRepo repo;

    @Test
    public void should_Insert_Employee() {
        Employee employee = Employee.builder()
                .id(123l)
                .salary(12000)
                .firstName("John")
                .lastName("Hickey")
                .build();

        Employee save = repo.save(employee);
        Assertions.assertNotNull(save);
        Assertions.assertEquals(12000, save.getSalary());
    }

/*    @Test
    public void TEST2() {

        List<Employee> all = repo.findAll();
        Assertions.assertNotNull(all);
        Assertions.assertEquals(1, all.size());
    }*/
}