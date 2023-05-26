package com.biglietOne.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.biglietOne.models.Artista;
import com.biglietOne.models.Entity;
import com.biglietOne.models.User;

public class ArtistaDao implements IDAO{
	
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
				
				int id = rs.getInt("ID_ARTISTA");
				
				mappaUser.put("Id", id+"");
				mappaUser.put("NomeArtista", rs.getString("NOME_ARTISTA"));
				mappaUser.put("InfArtista" , rs.getString("INF_ARTISTA"));
				
				map.put(id, context.getBean(Artista.class, mappaUser));
				
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
		// TODO Auto-generated method stub
		return false;
	}


	
	public Map<Integer, Entity> read(int id) {
		String query = "select * from artista where id_artista = ?";
		return executeQuery(query, id+"");
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
