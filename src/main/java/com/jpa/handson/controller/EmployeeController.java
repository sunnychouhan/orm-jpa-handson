package com.jpa.handson.controller;

import com.jpa.handson.entity.Employee;
import com.jpa.handson.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("employee = " + employee);
        return employeeService.persistEmployee(employee);

    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.fetchEmployee(id);

    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmployee")
    public Employee removeEmployee(@RequestBody Employee employee) {
        Employee employeeUpd = employeeService.updateEmployee(employee.getId(), employee);
        return employeeUpd;
    }

    @DeleteMapping("/removeEmployee/{id}")
    public String removeEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Delete Success";
    }

    @GetMapping("/pagination/{page}/{size}")
    public Page<Employee> getByPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Employee> employees = employeeService.paginageRecords(PageRequest.of(page, size, Sort.by(Sort.Order.by("id"))));
//        id.get().collect(Collectors.toList());
        return employees;
    }

}
