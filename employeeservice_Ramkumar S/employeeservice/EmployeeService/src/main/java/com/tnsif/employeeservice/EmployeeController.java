package com.tnsif.employeeservice;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employeeservice")
	public List<Employee> getAll(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/employeeservice/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Integer id) {
		try {
			Employee ad = service.getById(id);
			return new ResponseEntity<Employee>(ad,HttpStatus.OK);
		}catch(NoResultException e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
		
	@PostMapping("/employeeservice")
	public void save(@RequestBody Employee ad) {
		service.createEmployee(ad);
	}
	
	@PutMapping("/employeeservice/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee update_a) {
		try {
			Employee employee = service.getById(id);

			employee.setUsername(update_a.getUsername());
			employee.setPass(update_a.getPass());
			employee.setEmail(update_a.getEmail());
			employee.setRole(update_a.getRole());
			employee.setAddress(update_a.getAddress());
			service.updateEmployee(employee);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}catch(NoResultException e){
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/employeeservice/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteEmployee(id);
	}

}
