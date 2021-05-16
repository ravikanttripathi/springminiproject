package com.rk.service;

import java.util.List;

import com.rk.modle.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee getOneEmpObject(Integer id);

	public void updateEmployee(Employee enp);

	public void deleteEmployee(Integer id);

}
