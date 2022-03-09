package com.jpa.handson.controller;

import com.jpa.handson.entity.Department;
import com.jpa.handson.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartmentController {

    DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);

    }

    @GetMapping("/getAllDepartment")
    public List<Department> addDepartment() {
        List<Department> allDepartment = departmentService.getAllDepartment();
        return allDepartment;

    }

//    @DeleteMapping("/removeDepartment/{id}")
//    public String removeDepartment(@PathVariable Long id) {
//        return departmentService.removeDepartment(id);
//
//    }
}
