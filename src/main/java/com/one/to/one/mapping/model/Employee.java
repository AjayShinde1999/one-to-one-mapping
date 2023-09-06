package com.one.to.one.mapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name",length = 30)
    private String name;

    @Column(name = "emp_salary",length = 30)
    private String salary;

    @Column(name = "emp_role",length = 30)
    private String role;


}
