package com.sabuj.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabuj.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
