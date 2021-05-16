package com.rk.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.modle.Employee;
import com.rk.service.IEmployeeService;
import com.rk.service.IUserService;

@RestController
@RequestMapping("/restemp/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	// save employee
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		ResponseEntity<String> res = null;
		try {
			Integer id = service.saveEmployee(emp);
			String body = "Employee Save Successfully  ==>" + id;
			res = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("Unable to Save Employee", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	// Fetch all Employee
	@GetMapping("/all")
	public ResponseEntity<?> getAppEmployee() {
		ResponseEntity<?> res = null;
		try {
			List<Employee> list = service.getAllEmployee();
			res = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("Unable TO Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	// fetch one Employee by id
	@GetMapping("/one/{id}")
	public ResponseEntity<?> fetchOneData(@PathVariable("id") Integer id) {
		ResponseEntity<?> res = null;
		try {
			Employee emp = service.getOneEmpObject(id);
			res = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("Unable Featch Data ", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	// delete one Employee
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteOneEmployee(@PathVariable("id") Integer id) {
		ResponseEntity<String> res = null;
		try {
			service.deleteEmployee(id);
			String body = "Employee Deleted ";
			res = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("Employe Not Deleted ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	// update on employee
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody Employee emp) {
		ResponseEntity<String> res = null;
		try {
			service.updateEmployee(emp);
			String body = "Employee Updated Successfuly ";
			res = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("Employee Not Updated  ", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;

	}

}
