package com.biglietOne.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.biglietOne.models.Entity;
import com.biglietOne.models.Prenotazioni;

public class PrenotazioniDao implements IDAO {

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
				
				Map<String, String> mappaPrenotzioni = new HashMap<String, String>();
				
				int id = rs.getInt("ID_PRENOTAZIONE");
				
				mappaPrenotzioni.put("IdPrenotazione", id+"");
				mappaPrenotzioni.put("IdUtente", rs.getInt("ID_UTENTE")+"");
				mappaPrenotzioni.put("IdEventiDetails", rs.getInt("ID_EVENTIDETAILS")+"");
				mappaPrenotzioni.put("IdPrezzo", rs.getInt("ID_PREZZO")+"");
                map.put(id, context.getBean(Prenotazioni.class, mappaPrenotzioni) );
				
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
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    public Map<Integer, Entity> readFromEventDetails(int id) {
        String query = "select * from PRENOTAZIONI where ID_EVENTIDETAILS = ?";
	    return executeQuery(query, id+"");
    }

    @Override
    public boolean update(Entity e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public Map<Integer, Entity> read() {
        String query = "select * from PRENOTAZIONI where ID_EVENTIDETAILS";
	    return executeQuery(query);
    }
    
    
}
