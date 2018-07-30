package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAOWrapper;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAOWrapper employeeDao;
	
	@RequestMapping(value="emp/controller/getDetails", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		List<Employee> empList = new ArrayList<>(employeeDao.findAll());
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
}
