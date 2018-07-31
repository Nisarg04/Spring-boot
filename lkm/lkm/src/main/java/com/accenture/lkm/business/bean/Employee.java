package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;

public class Employee {

	
	private int employeeId;
	@NotNull(message="Employee name cannot be NULL!")
	private String employeeName;
	private Double salary;
	private Integer departmentCode;
	
	public Employee(int employeeId, String employeeName, Double salary, Integer departmentCode) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.departmentCode = departmentCode;
	}

	public Employee() {}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}
	@Override
	public String toString() {
		return "\nEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", departmentCode=" + departmentCode + "]";
	}

	
}
