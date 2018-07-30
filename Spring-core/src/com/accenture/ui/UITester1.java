package com.accenture.ui;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.dao.EmployeeDAO;
import com.accenture.entity.EmployeeEntityBean;

public class UITester1 {

	public static void main(String[] args) {
		EmployeeDAO dao = null;
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("com/accenture/resource/jpa_spring1.xml");
			dao = (EmployeeDAO) context.getBean("employeeDAO");
			
			/*String[] beans = context.getBeanDefinitionNames();
			for(String a : beans) {
				System.out.println(a);
			}*/
			
//			addEmployee(dao);
			customQueries(dao);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void customQueries(EmployeeDAO dao) {
		
		System.out.println("Employee with id 101 : " + dao.findOne(1));
		System.out.println("Salary greater than equal to 5000 : " + dao.findBySalaryGreaterThanEqual(5000.00));
		System.out.println("Get List by name using @Query " + dao.getAllEmployeesByName("LOL LOL"));
		System.out.println("Get List by name using @Query, @Param " + dao.getAllEmployeesByNameParamName("LOL LOL"));
	}

	private static void addEmployee(EmployeeDAO dao) {
		EmployeeEntityBean emp = new EmployeeEntityBean();
		emp.setId(101);
		emp.setInsertTime(new Date());
		emp.setName("LOL1 LOL1");
		emp.setRole("ASE");
		emp.setSalary(10000.00);
		
		Integer e = dao.save(emp).getId();
		System.out.println(e);
	}

}
