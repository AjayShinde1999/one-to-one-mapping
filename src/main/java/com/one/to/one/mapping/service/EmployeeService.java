package com.one.to.one.mapping.service;


import com.one.to.one.mapping.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public List<EmployeeDto> getAllEmployee();

    public EmployeeDto getEmployeeById(long id);

    public void deleteEmplyeeById(long id);

    public EmployeeDto updateEmployee(EmployeeDto employeeDto,long id);

}
