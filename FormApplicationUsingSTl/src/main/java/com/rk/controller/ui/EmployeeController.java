package com.rk.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.modle.Employee;
import com.rk.modle.User;
import com.rk.service.IEmployeeService;
import com.rk.service.IUserService;
import com.rk.validation.EmployeeValidation;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeValidation validation;
	@Autowired
	private IEmployeeService service;
	@Autowired
	private IUserService userService;

	@GetMapping("/register")
	public String getRegister() {
		return "UserRegister";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user, ModelMap map) {
		Integer id = userService.saveUser(user);
		String data = "User Save successfuly  " + id;
		map.addAttribute("data", data);
		return "UserRegister";
	}

	@GetMapping("/show")
	public String show(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeForm";
	}

	@PostMapping("/data")
	public String getData(@ModelAttribute Employee emp, ModelMap map, Errors errors) {
		validation.validate(emp, errors);
		String page = null;
		if (errors.hasErrors()) {
			page = "EmployeForm";
		} else {
			Integer id = service.saveEmployee(emp);
			String empdata = "Employee  " + id + "  Save Successfully";
			map.addAttribute("employee", new Employee());
			map.addAttribute("employee1", empdata);
			page = "EmployeForm";
		}

		return page;
	}

	@GetMapping("/data")
	public String showData(ModelMap map) {
		List<Employee> emp = service.getAllEmployee();
		map.addAttribute("list", emp);
		return "data";
	}

	@GetMapping("/edit")
	public String getOneObj(@RequestParam Integer id, ModelMap map) {
		Employee emp1 = service.getOneEmpObject(id);
		map.addAttribute("emp", emp1);
		return "EmployeeEdit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp, ModelMap map) {
		service.updateEmployee(emp);
		List<Employee> listemp = service.getAllEmployee();
		map.addAttribute("list", listemp);
		return "data";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, ModelMap map) {
		service.deleteEmployee(id);
		List<Employee> emp = service.getAllEmployee();
		map.addAttribute("list", emp);
		return "data";
	}
}
