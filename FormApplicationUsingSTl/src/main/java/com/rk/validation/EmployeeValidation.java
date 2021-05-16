package com.rk.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rk.modle.Employee;

@Component
public class EmployeeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp = (Employee) target;
		if (!Pattern.matches("[A-Za-z]{4,9}", emp.getEmpName())) {
			errors.rejectValue("empName", null, "Please Put A-Za-z min 4 max 9");
		}
		if (!Pattern.matches("[A-Za-z0-9]{4,8}", emp.getEmpPwd())) {
			errors.rejectValue("empPwd", null, "Please Put A-Z a-z min 4 max 9");
		}
		if (!StringUtils.hasText(emp.getEmmGen())) {
			errors.rejectValue("emmGen", null, "Please Select One Gender");
		}
		if (!Pattern.matches("[A-Za-z-0-9]{10,250}", emp.getEmpAddr())) {
			errors.rejectValue("empAddr", null, "Address Min 10 letter max 250");
		}
		if (!StringUtils.hasText(emp.getEmpCounty())) {
			errors.rejectValue("empCounty", null, "Please Select At List One Country");
		}
	}
}
