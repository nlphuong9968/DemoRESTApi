package com.example.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.User;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public User loadUserByUsername(final String username) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from User where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		
		List<User> users = query.list();
		
		if(users!=null && users.size() > 0) {
			return users.get(0);
		}else {
			return null;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean checkLogin(User userForm) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String hql = "from User where username = :username and password = :password ";
		Query query = session.createQuery(hql);
		query.setParameter("username", userForm.getUsername());
		query.setParameter("password", userForm.getPassword());
		
		List<User> users = query.list();
		if(users != null && users.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
}
