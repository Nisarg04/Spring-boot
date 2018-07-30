package com.accenture.lkm.business.bean;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private String role;
	private Double salary;
	private Date insertTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", insertTime="
				+ insertTime + "]";
	}
	
	
	
}
