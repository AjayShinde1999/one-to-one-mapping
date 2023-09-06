package com.one.to.one.mapping.payload;

import com.one.to.one.mapping.model.Employee;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EmployeeContactsDto {

    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    private String email;

    @Size(min = 10,max = 10,message = "Enter valid number")
    private String mobile;
    private Employee employee;
}
