package com.biglietOne.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Evento extends Entity{
	
	private String categoria;
	private String titolo;
	private Date primaData;
	private Date ultimaData;
	private Artista artista;
	private String infoEvento;
	private String locandina;
	private List<EventoDetail> listaEventoDetails;
	
	public Evento() {
		listaEventoDetails = new ArrayList<EventoDetail>();
	}
	
	public void setIdArtista(int id) {
		if(artista == null) {
			artista = new Artista();
		}
		artista.setId(id);
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Date getPrimaData() {
		return primaData;
	}
	public void setPrimaData(Date primaData) {
		this.primaData = primaData;
	}
	public Date getUltimaData() {
		return ultimaData;
	}
	public void setUltimaData(Date ultimaData) {
		this.ultimaData = ultimaData;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public String getInfoEvento() {
		return infoEvento;
	}
	public void setInfoEvento(String infoEvento) {
		this.infoEvento = infoEvento;
	}
	public String getLocandina() {
		return locandina;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}

	public List<EventoDetail> getListaEventoDetails() {
		return listaEventoDetails;
	}

	public void setListaEventoDetails(List<EventoDetail> listaEventoDetails) {
		this.listaEventoDetails = listaEventoDetails;
	}
	
	
	
	

}
