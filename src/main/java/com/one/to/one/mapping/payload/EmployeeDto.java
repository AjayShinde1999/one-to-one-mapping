package com.one.to.one.mapping.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Salary is required")
    private String salary;

    @NotBlank(message = "Role is required")
    private String role;
}
