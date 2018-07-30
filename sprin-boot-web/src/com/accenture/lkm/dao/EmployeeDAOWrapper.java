package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.entity.EmployeeEntityBean;
import com.accenture.lkm.business.bean.Employee;

@Repository
public class EmployeeDAOWrapper {
	
	@Autowired
	public EmployeeDAO dao;

	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<Employee>();
		
		Iterable<EmployeeEntityBean> listEn = dao.findAll();
		listEn.forEach(i -> {
			Employee e = new Employee();
			BeanUtils.copyProperties(i, e);
			list.add(e);
		});
		
		return list;
	}
	

}
