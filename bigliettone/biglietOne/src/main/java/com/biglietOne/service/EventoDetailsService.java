package com.biglietOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.models.Entity;
import com.biglietOne.database.EventiDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.database.LocationDao;
import com.biglietOne.models.Evento;
import com.biglietOne.models.EventoDetail;
import com.biglietOne.models.Location;

public class EventoDetailsService {
    @Autowired
    EventiDao eventiDao;

    @Autowired
    Evento evento;

    @Autowired
    EventoDetailDao eDetailDao;

    @Autowired
    EventoDetail eDetail;

    @Autowired
    LocationDao locationDao;

    public List<EventoDetail> getEventiDetailsByID(int Id) {

        List<EventoDetail> listaEventiDetails = new ArrayList<EventoDetail>();

        Map<Integer, Entity> mapEventiDetails = eDetailDao.read(Id);

        if (!mapEventiDetails.isEmpty()) {

            for (Entry<Integer, Entity> entryEventiDetail : mapEventiDetails.entrySet()) {

                EventoDetail e = (EventoDetail) entryEventiDetail.getValue();

                listaEventiDetails.add(e);
            }

        }

        return listaEventiDetails;

    }

    public List<EventoDetail> getEventiDetails() {

        List<EventoDetail> listaEventiDetails = new ArrayList<EventoDetail>();

        Map<Integer, Entity> mapEventiDetails = eDetailDao.read();

        if (!mapEventiDetails.isEmpty()) {

            for (Entry<Integer, Entity> entryEventiDetail : mapEventiDetails.entrySet()) {

                EventoDetail e = (EventoDetail) entryEventiDetail.getValue();

                listaEventiDetails.add(e);
            }

        }

        return listaEventiDetails;

    }

    public EventoDetail getEventoDetail(String Id) {

        EventoDetail e = null;

        Map<Integer, Entity> mapEventiDetails = eDetailDao.read(Integer.parseInt(Id));

        if (!mapEventiDetails.isEmpty()) {

            for (Entry<Integer, Entity> entryEventiDetail : mapEventiDetails.entrySet()) {

                e = (EventoDetail) entryEventiDetail.getValue();

                Map<Integer, Entity> mapLocation = locationDao.read(e.getIdLocation());
						Location l = null;
						if(!mapLocation.isEmpty()){
							for(Entry<Integer, Entity> location : mapLocation.entrySet()){
								l = (Location) location.getValue();
								e.setLocation(l);
								break;
							}
                        }
            }

        }

        return e;

    }

}
