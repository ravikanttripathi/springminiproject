package com.rk.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "emp_tab")
//@XmlRootElement
public class Employee {
	@Id
	@Column(name = "emp_id")
	@GeneratedValue
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_pwd")
	private String empPwd;
	@Column(name = "emp_gen")
	private String emmGen;
	@Column(name = "emp_addr")
	private String empAddr;
	@Column(name = "empCountry")
	private String empCounty;

	public Employee() {
		super();
	}

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmmGen() {
		return emmGen;
	}

	public void setEmmGen(String emmGen) {
		this.emmGen = emmGen;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getEmpCounty() {
		return empCounty;
	}

	public void setEmpCounty(String empCounty) {
		this.empCounty = empCounty;
	}

}
