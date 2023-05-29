package com.biglietOne.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaDao {
    
    @Autowired
	Database db;

    public List<String> executeQuery(String query, String... params) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		
		try {
			
			ps = db.getConnection().prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				
				list.add(rs.getString("CATEGORIA"));
				
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
		
		return list;
	}

    public List<String> getCategoria(){
        String query = "select DISTINCT CATEGORIA FROM EVENTI;";
    
        return executeQuery(query);
    }
}


