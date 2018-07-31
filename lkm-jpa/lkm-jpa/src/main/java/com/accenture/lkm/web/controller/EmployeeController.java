package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value="emp/controller")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;
	
	@RequestMapping(value="getDetails", 
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		List<Employee> empList = new ArrayList<>(empService.getEmployeeDetails());
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	@RequestMapping(value="addEmployee", 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee emp, Errors err) {
		if(err.hasErrors()) {
			return new ResponseEntity<>("Validation failure " + err.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Integer empId = empService.addEmployee(emp);
		return new ResponseEntity<>("Employee added with id : " + empId, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="getWithId/{id}", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empId) {
		Employee emp = empService.getEmployeeDetailByEmployeeId(empId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	

	@RequestMapping(value="updateEmployee", 
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		Employee updatedEmp = empService.updateEmployee(emp);
		return new ResponseEntity<>("Employee updated with id : " + updatedEmp.getEmployeeId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="deleteEmployee", 
			method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestBody Employee emp) {
		Employee deletedEmp = empService.deleteEmployee(emp.getEmployeeId());
		return new ResponseEntity<>("Employee deleted with id : " + deletedEmp.getEmployeeId(), HttpStatus.OK);
	}
	
}
