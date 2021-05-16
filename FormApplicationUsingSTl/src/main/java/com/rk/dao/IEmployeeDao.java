package com.rk.dao;

import java.util.List;

import com.rk.modle.Employee;

public interface IEmployeeDao {
	public Integer saveEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee getOneRecord(Integer id);

	public void updateEmployee(Employee enp);

	public void deleteEmployee(Integer id);

}
