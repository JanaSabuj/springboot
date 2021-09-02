package com.sabuj.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabuj.demo.dao.EmployeeRepository;
import com.sabuj.demo.entity.Employee;
import com.sabuj.demo.exception.ResourceNotFoundException;
import com.sabuj.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent())
			throw new ResourceNotFoundException("Employee", "Id", id);
		
		return employee.get();
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if(!existingEmployee.isPresent())
			throw new ResourceNotFoundException("Employee", "Id", id);
		
		Employee oldEmployee = existingEmployee.get();
		oldEmployee.setFirstName(employee.getFirstName());	
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setEmail(employee.getEmail());
		
		// save
		employeeRepository.save(oldEmployee);
		return oldEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if(!existingEmployee.isPresent())
			throw new ResourceNotFoundException("Employee", "Id", id);
		
		employeeRepository.deleteById(id);
	}

}
