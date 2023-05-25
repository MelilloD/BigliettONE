package com.biglietOne.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.database.UserDao;
import com.biglietOne.models.Entity;
import com.biglietOne.models.User;



public class UserService {
	
	@Autowired
	private UserDao uDao;
	
	public User checkUser(String username, String password) {
		User u = null;
		
		Map<Integer, Entity> map = uDao.read(username, password);
		
		if(!map.isEmpty()) {
			for(Entry e : map.entrySet() ) {
				u = (User) e.getValue();
				break;
			}
		}
		
		return u;
	}
	
	public void registraUtente(User u) {
		uDao.create(u);
	}

}
