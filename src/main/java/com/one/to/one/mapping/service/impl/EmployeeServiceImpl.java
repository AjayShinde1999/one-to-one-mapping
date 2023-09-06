package com.one.to.one.mapping.service.impl;

import com.one.to.one.mapping.exception.ResourceNotFoundException;
import com.one.to.one.mapping.model.Employee;
import com.one.to.one.mapping.payload.EmployeeDto;
import com.one.to.one.mapping.repository.EmployeeRepository;
import com.one.to.one.mapping.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        log.info("employeeDto {} ",employeeDto);
        Employee employee = mapToEntity(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        log.info("Data Saved {} ",saveEmployee);
        return mapToDto(saveEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        log.info("List Of Employee {} ",employees);
        return employees.stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found With Id : " + id)
        );
        log.info("Employee Data {} ",employee);
        return mapToDto(employee);
    }

    @Override
    public void deleteEmplyeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found With Id : " + id)
        );
        log.info("Employee Details {}",employee);
        employeeRepository.delete(employee);
        log.info("Employee Record Deleted {}",employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found With Id : " + id)
        );

        log.info("Employee details of id "+id+"  {}",employee);

        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setRole(employeeDto.getRole());
        log.info("Employee data updated {}",employee);
        Employee updatedEmployee = employeeRepository.save(employee);
        log.info("Updated Employee Record Saved {}",updatedEmployee);
        return mapToDto(updatedEmployee);
    }

    public Employee mapToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    public EmployeeDto mapToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
