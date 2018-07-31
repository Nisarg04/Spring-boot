package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.Employee;

@Repository
public class EmployeeDAO {

	public static Map<Integer, Employee> mapOfEmployees =
			 new LinkedHashMap<>();
	static int count = 1004;
	
	static {
		mapOfEmployees.put(1001, new Employee(1001, "Jack", 1234.5, 101));
		mapOfEmployees.put(1002, new Employee(1002, "John", 1267.5, 102));
		mapOfEmployees.put(1003, new Employee(1003, "Josh", 1794.7, 103));
	}
	
	public Collection<Employee> getAllEmployees() {
		return mapOfEmployees.values();
	}
	
	public Employee getEmployeeById(int id) {
		return mapOfEmployees.get(id);
	}

	public Integer addEmployee(Employee emp) {
		count++;
		mapOfEmployees.put(count, new Employee(count, emp.getEmployeeName(), emp.getSalary(), emp.getDepartmentCode()));
		return count;
	}
}
