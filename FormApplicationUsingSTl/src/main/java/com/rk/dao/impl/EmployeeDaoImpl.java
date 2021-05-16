package com.rk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rk.dao.IEmployeeDao;
import com.rk.modle.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveEmployee(Employee emp) {
		Integer id = (Integer) ht.save(emp);
		return id;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emp = ht.loadAll(Employee.class);
		return emp;
	}

	@Override
	public Employee getOneRecord(Integer id) {
		Employee emp = ht.get(Employee.class, id);
		return emp;
	}

	@Override
	public void updateEmployee(Employee enp) {
		ht.update(enp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		ht.delete(new Employee(id));
	}

}
