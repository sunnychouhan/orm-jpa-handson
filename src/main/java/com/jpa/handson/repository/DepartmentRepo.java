package com.jpa.handson.repository;

import com.jpa.handson.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
//    @Query("select DISTINCT d from Department d JOIN FETCH d.employeeList")
//    List<Department> getDepartments();
}
