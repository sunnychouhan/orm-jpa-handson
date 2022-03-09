package com.jpa.handson.service;

import com.jpa.handson.entity.Employee;
import com.jpa.handson.model.Student;
import com.jpa.handson.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
//@CacheConfig(cacheNames = {EmployeeService.EMPLOYEE_CACHE})
public class EmployeeService {
    public static final String EMPLOYEE_CACHE = "employee_cache";
    EmployeeRepo employeeRepo;
    Student student;

    @Transactional
    public Employee persistEmployee(Employee employee) {
        System.out.println("student = " + student);
        Employee saveEmp = employeeRepo.save(employee);
        return saveEmp;
    }


    @Cacheable(value = EMPLOYEE_CACHE, key = "#id")
    public Employee fetchEmployee(Long id) {
        Optional<Employee> byId = employeeRepo.findById(id);
        return byId.orElse(Employee.builder().build());
    }

    @CacheEvict(value = EMPLOYEE_CACHE, key = "#id")
    public void deleteEmployee(Long id) {
        employeeRepo.delete(Employee.builder().id(id).build());
    }

    @CachePut(value = EMPLOYEE_CACHE, key = "#employee.id")
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updatedEmp = employeeRepo.save(employee);
        return updatedEmp;
    }

    @Cacheable(cacheNames = "allEmp")
    public List<Employee> getAllEmployee() {
        System.out.println("student = " + student);
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }

    public Page<Employee> paginageRecords(Pageable pageable) {
        Page<Employee> all = employeeRepo.findAll(pageable);
        return all;
    }
}
