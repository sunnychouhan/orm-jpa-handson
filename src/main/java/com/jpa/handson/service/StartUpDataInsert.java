package com.jpa.handson.service;

import com.jpa.handson.repository.DepartmentRepo;
import com.jpa.handson.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartUpDataInsert {

    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
//            List<String> departments = Arrays.asList("FINANCE:Delhi",
//                    "ADMINISTRATIVE:Mumbai",
//                    "SECURITY:Pune",
//                    "HR:Chennai");
//            departments.forEach(s -> {
//                        String[] split = s.split(":");
//                        departmentRepo.save(Department.builder().name(split[0]).location(split[1]).build());
//                    }
//            );
//
//            List<Employee> employeeList = Arrays.asList(
//                    Employee.builder().firstName("Rahul").lastName("Roy").salary(10000).build(),
//                    Employee.builder().firstName("Anup").lastName("bhatt").salary(12000).build(),
//                    Employee.builder().firstName("Abhi").lastName("sharma").salary(11000).build(),
//                    Employee.builder().firstName("Manish").lastName("Jain").salary(13000).build()
//            );
//            employeeList.forEach(s -> employeeRepo.save(s));
        };
    }
}
