package com.one.to.one.mapping.model;

import com.one.to.one.mapping.payload.EmployeeDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_contacts")
public class EmployeeContacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "mobile_number")
    private String mobile;

    @OneToOne(targetEntity = Employee.class)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

}
