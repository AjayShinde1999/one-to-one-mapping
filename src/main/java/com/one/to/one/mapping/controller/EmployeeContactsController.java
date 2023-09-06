package com.one.to.one.mapping.controller;

import com.one.to.one.mapping.payload.EmployeeContactsDto;
import com.one.to.one.mapping.service.EmployeeContactsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/contacts")
public class EmployeeContactsController {

    private final EmployeeContactsService employeeContactsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{empId}")
    public EmployeeContactsDto saveEmployeeContacts(@Valid @RequestBody EmployeeContactsDto employeeContactsDto, @PathVariable("empId") long empId) {
       return employeeContactsService.saveEmployeeContacts(empId,employeeContactsDto);
    }
}
