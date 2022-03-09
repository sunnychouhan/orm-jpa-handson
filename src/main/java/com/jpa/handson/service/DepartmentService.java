package com.jpa.handson.service;

import com.jpa.handson.entity.Department;
import com.jpa.handson.repository.DepartmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    public static final String DEPARTMENT_CACHE = "department_cache";
    DepartmentRepo departmentRepo;

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Cacheable(DEPARTMENT_CACHE)
    public List<Department> getAllDepartment() {
        List<Department> allDepartment = departmentRepo.findAll();

//        List<Department> allDepartment = departmentRepo.getDepartments();
        return allDepartment;
    }

//    public Department buildDepartmentWithEmployee(Department department) {
//        Department departmentjpa = Department.builder()
//                .name(department.getName())
//                .location(department.getLocation())
//                .employeeList(new ArrayList<>())
//                .build();
//        department.getEmployeeList().forEach(employee -> departmentjpa.addEmployee(employee));
//        return departmentjpa;
//    }
//
//    public String  removeDepartment(Long id) {
//        Optional<Department> byId = departmentRepo.findById(id);
//        departmentRepo.delete(byId.get());
//        return "Success";
//    }
}
