package com.biglietOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.events.Event;

import com.biglietOne.database.ArtistaDao;
import com.biglietOne.database.CategoriaDao;
import com.biglietOne.database.CittaDao;
import com.biglietOne.database.EventiDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.database.LocationDao;
import com.biglietOne.models.Artista;
import com.biglietOne.models.Citta;
import com.biglietOne.models.Entity;
import com.biglietOne.models.Evento;
import com.biglietOne.models.EventoDetail;
import com.biglietOne.models.Location;

public class EventoService {

	@Autowired
	EventiDao eventiDao;

	@Autowired
	ArtistaDao artistaDao;

	@Autowired
	LocationDao locationDao;

	@Autowired
	CittaDao cittaDao;

	@Autowired
	CategoriaDao catDao;
	
	@Autowired
	EventoDetailDao eventoDetailDao;
	
	public List<Evento> getEventi(){
		
		
		
		List<Evento> listaEventi = new ArrayList<Evento>();
		
		Map<Integer, Entity> mapEventi = eventiDao.read();
		if(!mapEventi.isEmpty()){
			for(Entry<Integer, Entity> entryEventi : mapEventi.entrySet()) {
				
				Evento e = (Evento) entryEventi.getValue();
				
				Map<Integer,Entity> mapArtista =  artistaDao.read(e.getArtista().getId());
				
				if(!mapArtista.isEmpty()){
					Artista a = null;
					for(Entry artista : mapArtista.entrySet()){
						a = (Artista) artista.getValue();
						break;
					}
		
					e.setArtista(a);
				}
				
				
				Map<Integer, Entity> mapEventiDetail = eventoDetailDao.read(e.getId());
				if(!mapEventiDetail.isEmpty()){
					for(Entry<Integer, Entity> entryEventiDetail : mapEventiDetail.entrySet()) {
						
						EventoDetail eD = (EventoDetail) entryEventiDetail.getValue();
						

						Map<Integer, Entity> mapLocation = locationDao.read(eD.getIdLocation());
						Location l = null;
						if(!mapLocation.isEmpty()){
							for(Entry<Integer, Entity> location : mapLocation.entrySet()){
								l = (Location) location.getValue();
								eD.setLocation(l);
								break;
							}

							Map<Integer,Entity> mapCitta =  cittaDao.read(l.getIdCitta());
							if(!mapCitta.isEmpty()){
								for(Entry<Integer, Entity> citta : mapCitta.entrySet()){
									Citta c = (Citta) citta.getValue();
									l.setCitta(c);
									break;
								}

							}

						}
						e.getListaEventoDetails().add(eD);

						
					}
				}
				listaEventi.add(e);
				
			}
		}
		
		return listaEventi;
		
	}

	public Evento getEvento(String idEvento){
		Evento e = null;
		
		Map<Integer, Entity> mapEventi = eventiDao.read(Integer.parseInt(idEvento));
		for(Entry<Integer, Entity> entryEventi : mapEventi.entrySet()) {
			
			e = (Evento) entryEventi.getValue();

		}

		return e;
	}

	public List<String> getCategorie(){
		return catDao.getCategoria();
	}
	
}
