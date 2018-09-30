package com.swacorp.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swacorp.springweb.dao.UserDao;
import com.swacorp.springweb.model.Users;

@Transactional
@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public List<Users> validateUserLogin(String userName) {

		return userDao.findyByuserName(userName);

	}
	
	public void save(Users user) {

		userDao.save(user);

	}

}
