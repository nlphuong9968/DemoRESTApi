package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User loadUserByUsername(final String username) {
		return userDAO.loadUserByUsername(username);
	}
	
	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}

}
