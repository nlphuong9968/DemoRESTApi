package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRESTController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * list all of employee
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Employee> getEmployees(){
		List<Employee> list = employeeService.getAllEmps();
		return list;
	}
	
	/**
	 * get detail of employee
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable("empId") Integer empId) {
		return employeeService.getEmp(empId);
	}
	
	/**
	 * Add a new employee
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee getEmployee(@RequestBody Employee empForm) {
		System.out.println("(Service Side) Createing employee with empNo: "+empForm.getEmpNo());
		return employeeService.addEmployee(empForm);
	}
	
	/**
	 * Update detail of employee
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee empForm) {
		System.out.println("(Service Side) Editing employee with ID: "+empForm.getEmpId());
		return employeeService.updateEmp(empForm);
	}
	
	/**
	 * delete a employee
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String deleteEmployee(@PathVariable("empId") Integer empId) {
		System.out.println("(Service Side) Deleting employe with ID: "+empId);
		employeeService.deleteEmp(empId);
		return "Delete id "+empId+" successful";
	}
		
}
