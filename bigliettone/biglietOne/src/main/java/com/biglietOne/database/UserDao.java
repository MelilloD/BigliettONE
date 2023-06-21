package com.biglietOne.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.biglietOne.models.Entity;
import com.biglietOne.models.User;

public class UserDao  implements IDAO {
	
	@Autowired
	Database db;
	
	@Autowired
	private ApplicationContext context;
	
	public Map<Integer, Entity> executeQuery(String query, String... params) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Entity> map = new HashMap<Integer, Entity>();
		
		try {
			
			ps = db.getConnection().prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Map<String, String> mappaUser = new HashMap<String, String>();
				
				int id = rs.getInt("ID_UTENTE");
				
				mappaUser.put("Id", id+"");
				mappaUser.put("Email", rs.getString("EMAIL"));
				mappaUser.put("Username" , rs.getString("USERNAME"));
				mappaUser.put("Password" , rs.getString("PASS"));
				mappaUser.put("Nome",rs.getString("NOME"));
				mappaUser.put("Cognome",rs.getString("COGNOME"));
				mappaUser.put("EventiPreferiti",rs.getString("EVENTI_PREFERITE"));
				mappaUser.put("CategoriePreferite",rs.getString("CATEGORIE_PREFERITE"));
				mappaUser.put("DataNascita", rs.getString("DATA_NASCITA"));
				mappaUser.put("CittaUser", rs.getString("CITTA_USER"));
				mappaUser.put("ProvinciaUser", rs.getString("PROVINCIA_USER"));
				
				map.put(id, context.getBean(User.class, mappaUser));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return map;
	}

	
	public boolean executeUpdate(String query, String... params) {
		PreparedStatement ps = null;
			
		try {
			
			ps = db.getConnection().prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			
			int ritorno = ps.executeUpdate();
			if(ritorno == 0) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public boolean create(Entity e) {
		String query = "insert into utenti (EMAIL,NOME,COGNOME,DATA_NASCITA, USERNAME, PASS,EVENTI_PREFERITE,CATEGORIE_PREFERITE,CITTA_USER,PROVINCIA_USER) values (?, ?, ?,?,?,?,?,?,?,?);";
		User u = (User) e;
		
		return executeUpdate(query, u.getEmail(),u.getNome(),u.getCognome(),u.getDataNascita().toString(), u.getUsername(), u.getPassword(),u.getEventiPreferiti(),u.getCategoriePreferite(),u.getCittaUser(),u.getProvinciaUser());
	}
	
	public Map<Integer, Entity> read(String username, String password) {
		
		String query = "select * from utenti where username = ? and pass = ?";
		
		return executeQuery(query, username, password);
	}

	@Override
	public Map<Integer, Entity> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
