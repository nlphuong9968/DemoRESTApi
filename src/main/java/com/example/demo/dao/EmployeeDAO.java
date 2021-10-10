package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Employee;

@Repository
@Transactional(rollbackFor = Exception.class)
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee getEmp(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empId);
		return emp;
	}
	
	public Employee addEmp(Employee empForm) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empForm);
		return empForm;
	}
	
	public Employee updateEmp(Employee empForm) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empForm.getEmpId());
		
		emp.setEmpNo(empForm.getEmpNo());
		emp.setEmpName(empForm.getEmpName());
		
		session.update(emp);
		
		return emp;
	}
	
	public void deleteEmp(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empId);
		session.delete(emp);
	}
	
	public List<Employee> getAllEmps() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery(" FROM "+Employee.class.getName()).list();
		return employees;
	}

}
