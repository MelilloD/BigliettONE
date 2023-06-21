package com.biglietOne.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.Context;
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

	public void addUser(Map<String, String> params) {
		User u = new User();

		u.setNome(params.get("Nome"));
		u.setCognome(params.get("Cognome"));
		u.setDataNascita(Date.valueOf(params.get("DataNascita")));
		u.setCittaUser(params.get("CittaUser"));
		u.setProvinciaUser(params.get("ProvinciaUser"));
		u.setEmail(params.get("Email"));
		u.setUsername(params.get("Username"));
		u.setPassword(params.get("Password"));

		uDao.create(u);
	}

	public void registraUtente(User u) {
		uDao.create(u);
	}

	public List<String> listEventiPreferiti(User u){

		String[] row = u.getEventiPreferiti().split(",");

		List<String> listEvent = new ArrayList<String>();
		
		for (String e : row) {
			listEvent.add(e);
		}

		


		return listEvent;
	}

	public List<String> listCategoriePreferite(User u){

		String[] row = u.getCategoriePreferite().split(",");

		List<String> listCategoria = new ArrayList<String>();
		
		for (String e : row) {
			listCategoria.add(e);
		}

	
		return listCategoria;
	}

}
