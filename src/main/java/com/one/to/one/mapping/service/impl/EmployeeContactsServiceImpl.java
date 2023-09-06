package com.one.to.one.mapping.service.impl;

import com.one.to.one.mapping.exception.DuplicateEntryException;
import com.one.to.one.mapping.exception.ResourceNotFoundException;
import com.one.to.one.mapping.model.Employee;
import com.one.to.one.mapping.model.EmployeeContacts;
import com.one.to.one.mapping.payload.EmployeeContactsDto;
import com.one.to.one.mapping.repository.EmployeeContactsRepository;
import com.one.to.one.mapping.repository.EmployeeRepository;
import com.one.to.one.mapping.service.EmployeeContactsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeContactsServiceImpl implements EmployeeContactsService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeContactsRepository employeeContactsRepository;

    private final ModelMapper modelMapper;

    @Override
    public EmployeeContactsDto saveEmployeeContacts(long empId, EmployeeContactsDto employeeContactsDto) {

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found with Id : " + empId)
        );

        EmployeeContacts empContacts = employeeContactsRepository.findByEmployee_Id(empId);
        if (empContacts == null) {
            employeeContactsDto.setEmployee(employee);
            EmployeeContacts employeeContacts = mapToEntity(employeeContactsDto);

            EmployeeContacts saveContacts = employeeContactsRepository.save(employeeContacts);
            return mapToDto(saveContacts);
        }
        throw new DuplicateEntryException("Employee already updated contacts");

    }

    public EmployeeContacts mapToEntity(EmployeeContactsDto employeeContactsDto) {
        return modelMapper.map(employeeContactsDto, EmployeeContacts.class);
    }

    public EmployeeContactsDto mapToDto(EmployeeContacts employeeContacts) {
        return modelMapper.map(employeeContacts, EmployeeContactsDto.class);
    }
}
