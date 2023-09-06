package com.one.to.one.mapping.service;

import com.one.to.one.mapping.payload.EmployeeContactsDto;

public interface EmployeeContactsService {

    public EmployeeContactsDto saveEmployeeContacts(long empId, EmployeeContactsDto employeeContactsDto);
}
