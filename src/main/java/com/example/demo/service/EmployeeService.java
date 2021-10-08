package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entities.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public Employee getEmp(Integer empId) {
		return employeeDAO.getEmp(empId);
	}
	
	public Employee addEmployee(Employee empForm) {
		return employeeDAO.addEmp(empForm);
	}
	
	public Employee updateEmp(Employee empForm) {
		return employeeDAO.updateEmp(empForm);
	}
	
	public void deleteEmp(Integer empId) {
		employeeDAO.deleteEmp(empId);
	}
	
	public List<Employee> getAllEmps() {
		return employeeDAO.getAllEmps();
	}
}
