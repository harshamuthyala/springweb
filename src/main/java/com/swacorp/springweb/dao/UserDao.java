package com.swacorp.springweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.swacorp.springweb.model.Users;

@Transactional
@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Users user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		session.save(user);
		tx.commit();

	}

	//@Transactional
	@SuppressWarnings("unchecked")
	public List<Users> findyByuserName(String userName) {
		
		List<Users> user = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NativeQuery<Users> query = session.createSQLQuery("select * from users where username = :userName");
		query.addEntity(Users.class);
		query.setParameter("userName", userName);
		user = query.getResultList();
		
		
		tx.commit();

		return user;
	}

}
