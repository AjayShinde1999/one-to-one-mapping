package com.one.to.one.mapping.controller;

import com.one.to.one.mapping.payload.EmployeeDto;
import com.one.to.one.mapping.service.EmployeeService;
import com.one.to.one.mapping.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        log.info("URL Request");
        return employeeService.getAllEmployee();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") long id) {
        log.info("URL Request with Id {}", id);
        return employeeService.getEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ApiResponse deleteEmployeeById(@PathVariable("id") long id) {
        log.info("URL Request with Id {}", id);
        employeeService.deleteEmplyeeById(id);
        return new ApiResponse("Deleted Successfully", true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id) {
        log.info("URL Request with Id {}",id);
        log.info("URL Request with Payload {}",employeeDto);
        return employeeService.updateEmployee(employeeDto, id);
    }
}
