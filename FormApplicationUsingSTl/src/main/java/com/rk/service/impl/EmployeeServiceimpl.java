package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.IEmployeeDao;
import com.rk.modle.Employee;
import com.rk.service.IEmployeeService;

@Service
public class EmployeeServiceimpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	@Override
	@Transactional
	public Integer saveEmployee(Employee emp) {
		Integer id = dao.saveEmployee(emp);
		return id;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		List<Employee> emp = dao.getAllEmployee();
		return emp;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee getOneEmpObject(Integer id) {
		Employee emp = dao.getOneRecord(id);
		return emp;
	}

	@Override
	@Transactional
	public void updateEmployee(Employee enp) {
		dao.updateEmployee(enp);
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

}
