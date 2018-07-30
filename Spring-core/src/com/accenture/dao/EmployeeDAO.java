package com.accenture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.accenture.entity.EmployeeEntityBean;

public interface EmployeeDAO extends CrudRepository<EmployeeEntityBean, Integer> {
	List<EmployeeEntityBean> findBySalaryGreaterThanEqual(Double salary);

	//uses sequence
	@Query("select k from EmployeeEntityBean k where k.name=?1")
	List<EmployeeEntityBean> getAllEmployeesByName(String name);
	
	//uses parameter
	@Query("select k from EmployeeEntityBean k where k.name=:name")
	List<EmployeeEntityBean> getAllEmployeesByNameParamName(@Param("name")String name);
	
}
