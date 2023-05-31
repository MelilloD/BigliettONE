package com.biglietOne.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.Context;
import com.biglietOne.database.CittaDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.database.PrezziDao;
import com.biglietOne.database.UserDao;
import com.biglietOne.models.Citta;
import com.biglietOne.models.Entity;
import com.biglietOne.models.EventoDetail;
import com.biglietOne.models.Prezzo;
import com.biglietOne.models.User;

public class PrezzoService {

	@Autowired
	private PrezziDao pDao;

	@Autowired
	private EventoDetailDao eDetailDao;

	@Autowired
	private EventoDetailsService eDetailService;

	public List<Prezzo> getPrezzi() {

		List<Prezzo> listaPrezzi = new ArrayList<Prezzo>();

		Map<Integer, Entity> mapPrezzi = pDao.read();

		if (!mapPrezzi.isEmpty()) {

			for (Entry<Integer, Entity> entryPrezzi : mapPrezzi.entrySet()) {

				Prezzo p = (Prezzo) entryPrezzi.getValue();

				Map<Integer, Entity> mapEventiDetails = eDetailDao.read(p.getIdEventoDetail());

				if (!mapEventiDetails.isEmpty()) {
					EventoDetail ed = null;
					for (Entry<Integer, Entity> entryEventiDetail : mapEventiDetails.entrySet()) {

						ed = (EventoDetail) entryEventiDetail.getValue();
						break;
					}
					
					p.setEventoDetail(ed);
				}

				listaPrezzi.add(p);
			}
		}
		return listaPrezzi;
	}
}