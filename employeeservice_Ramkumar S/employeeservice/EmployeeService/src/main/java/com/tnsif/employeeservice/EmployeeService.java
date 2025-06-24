package com.tnsif.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	//to get all records
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	//to get particular record
	public Employee getById(Integer id) {
		return repo.findById(id).get();
	}
	
	//to save record
	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	//to update the records
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}
	
	//to delete records
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
}
