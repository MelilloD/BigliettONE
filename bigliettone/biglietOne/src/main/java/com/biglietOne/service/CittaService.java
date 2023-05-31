package com.biglietOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.database.CittaDao;
import com.biglietOne.database.LocationDao;
import com.biglietOne.models.Citta;
import com.biglietOne.models.Entity;
import com.biglietOne.models.Location;

public class CittaService {

    @Autowired
    CittaDao cDao;

    @Autowired
    LocationDao lDao;

    public List<Citta> getCitta(){
        List<Citta> listaCitta = new ArrayList<Citta>();

        Map<Integer, Entity> mapCitta = cDao.read();

        for(Entry<Integer, Entity> citta : mapCitta.entrySet()){
            Citta c = (Citta) citta.getValue();

            Map<Integer, Entity> mapLocation = lDao.readFromIdCitta(c.getId());

            for(Entry<Integer, Entity> location : mapLocation.entrySet()){
                Location l = (Location) location.getValue();
                c.getListaLocation().add(l);
            }

            listaCitta.add(c);

        }
        

        return listaCitta;
    }
    
    public Citta getCittaFromId(int id){
        Citta cit = new Citta();

        Map<Integer, Entity> mapCitta = cDao.read(id);

        for(Entry<Integer, Entity> citta : mapCitta.entrySet()){
            Citta c = (Citta) citta.getValue();

            Map<Integer, Entity> mapLocation = lDao.readFromIdCitta(c.getId());

            for(Entry<Integer, Entity> location : mapLocation.entrySet()){
                Location l = (Location) location.getValue();
                c.getListaLocation().add(l);
            }

            cit = c;

        }
        

        return cit;
    }
}
