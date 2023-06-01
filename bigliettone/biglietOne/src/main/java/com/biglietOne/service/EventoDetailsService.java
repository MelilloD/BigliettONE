package com.biglietOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.models.Entity;
import com.biglietOne.database.EventiDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.models.Evento;
import com.biglietOne.models.EventoDetail;

public class EventoDetailsService {
    @Autowired
    EventiDao eventiDao;

    @Autowired
    Evento evento;

    @Autowired
    EventoDetailDao eDetailDao;

    @Autowired
    EventoDetail eDetail;

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

}
