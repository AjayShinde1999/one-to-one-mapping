package com.one.to.one.mapping.repository;

import com.one.to.one.mapping.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
