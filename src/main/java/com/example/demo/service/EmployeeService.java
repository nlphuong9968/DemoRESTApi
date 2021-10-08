package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public Employee getEmp(Long empId) {
		return employeeDAO.getEmp(empId);
	}
	
	public Employee addEmployee(Employee empForm) {
		return employeeDAO.addEmp(empForm);
	}
	
	public Employee updateEmp(Employee empForm) {
		return employeeDAO.updateEmp(empForm);
	}
	
	public void deleteEmp(Long empId) {
		employeeDAO.deleteEmp(empId);
	}
	
	public List<Employee> getAllEmps() {
		return employeeDAO.getAllEmps();
	}
}
