package com.biglietOne.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.biglietOne.models.Entity;
import com.biglietOne.models.Location;

public class LocationDao implements IDAO {

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
				
				Map<String, String> mappaLocation = new HashMap<String, String>();
				
				int id = rs.getInt("ID_LOCATION");
				
				mappaLocation.put("Id", id+"");
				mappaLocation.put("NomeLocation", rs.getString("NOME_LOCATION"));
				mappaLocation.put("TipologiaLocation" , rs.getString("TIPOLOGIA_LOCATION"));
				mappaLocation.put("IdCitta" , rs.getString("ID_CITTA"));
				mappaLocation.put("Indirizzo" , rs.getString("INDIRIZZO"));
				mappaLocation.put("Capienza" , rs.getInt("CAPIENZA")+"");
				mappaLocation.put("IndicazioniStradali" , rs.getString("INDICAZIONI_STRADALI"));
				
				map.put(id, context.getBean(Location.class, mappaLocation));
				
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


	@Override
	public Map<Integer, Entity> read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Map<Integer, Entity> read(int id) {
		String query = "SELECT * FROM LOCATIONS WHERE ID_LOCATION = ?;";
		return executeQuery(query, id+"");
	}

	public Map<Integer, Entity> readFromIdCitta(int id) {
		String query = "SELECT * FROM LOCATIONS WHERE ID_CITTA = ?;";
		return executeQuery(query, id+"");
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
