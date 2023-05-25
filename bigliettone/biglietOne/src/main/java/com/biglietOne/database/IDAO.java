package com.biglietOne.database;

import java.util.Map;

import com.biglietOne.models.Entity;

public interface IDAO {
	
		
	public boolean create(Entity e);
	
	public Map<Integer, Entity> read();
	
	public boolean update(Entity e);
	
	public boolean delete(int id);

}
