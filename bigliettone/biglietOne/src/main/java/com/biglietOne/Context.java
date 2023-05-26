package com.biglietOne;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.biglietOne.database.ArtistaDao;
import com.biglietOne.database.CittaDao;
import com.biglietOne.database.Database;
import com.biglietOne.database.EventiDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.database.LocationDao;
import com.biglietOne.database.PrezziDao;
import com.biglietOne.database.UserDao;
import com.biglietOne.models.Artista;
import com.biglietOne.models.Citta;
import com.biglietOne.models.Evento;
import com.biglietOne.models.EventoDetail;
import com.biglietOne.models.Location;
import com.biglietOne.models.Prezzo;
import com.biglietOne.models.User;
import com.biglietOne.service.CittaService;
import com.biglietOne.service.EventoService;
import com.biglietOne.service.UserService;

@Configuration
public class Context {

	
	@Bean
	public Database db() {
		return new Database("db");
	}
	

	@Bean
	public ArtistaDao artistaDao() {
		
		return new ArtistaDao();
	}
	
	@Bean
	public UserDao userDao() {
		
		return new UserDao();
	}
	
	@Bean
	public CittaDao cittaDao() {
		
		return new CittaDao();
	}
	
	@Bean
	public EventiDao eventiDao(){
	    return new EventiDao();
	}
	
	@Bean
	public EventoDetailDao eventiDetailDao(){
	    return new EventoDetailDao();
	}
	
	@Bean
	public LocationDao locationDao(){
	    return new LocationDao();
	}
	
	
	
	@Bean
	public UserService getDipendentiService() {
		return new UserService();
	}
	
	
	
	@Bean
	public EventoService getEventoService() {
		return new EventoService();
	}

	@Bean
	public CittaService getCittaService() {
		return new CittaService();
	}
	
	@Bean
	public PrezziDao prezziDao(){
	    return new PrezziDao();
	}
	
	@Bean
	@Scope("prototype")
	public User newCliente(Map<String, String> param) {
		return (User) new User().fromMap(param);
	}
	
	@Bean
	@Scope("prototype")
	public Citta newCitta(Map<String, String> param) {
		return (Citta) new Citta().fromMap(param);
	}
	
	@Bean
	@Scope("prototype")
	public Artista newArtista(Map<String, String> param) {
		return (Artista) new Artista().fromMap(param);
	}
	
	
	
	@Bean
	@Scope("prototype")
	public EventoDetail newEventoDetail(Map<String, String> param) {
		return (EventoDetail) new EventoDetail().fromMap(param);
	}
	
	@Bean
	@Scope("prototype")
	public Location newLocation(Map<String, String> param) {
		return (Location) new Location().fromMap(param);
	}
	
	

	@Bean
	@Scope("prototype")
	    public Evento newEvento(Map<String, String> params) {
	        return (Evento) new Evento().fromMap(params);
	    }
	@Bean
    @Scope("prototype")
    public Prezzo newPrezzo(Map<String, String> params) {
        return (Prezzo) new Prezzo().fromMap(params);
	}
}

