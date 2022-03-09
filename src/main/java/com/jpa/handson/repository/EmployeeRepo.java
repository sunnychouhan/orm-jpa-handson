package com.jpa.handson.repository;

import com.jpa.handson.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
