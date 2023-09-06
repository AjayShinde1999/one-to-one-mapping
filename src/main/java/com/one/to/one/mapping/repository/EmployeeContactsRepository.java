package com.one.to.one.mapping.repository;

import com.one.to.one.mapping.model.EmployeeContacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeContactsRepository extends JpaRepository<EmployeeContacts,Long> {

    EmployeeContacts findByEmployee_Id(Long empId);
}
