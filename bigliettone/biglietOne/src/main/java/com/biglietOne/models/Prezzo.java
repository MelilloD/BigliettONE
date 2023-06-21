package com.biglietOne.models;

public class Prezzo extends Entity{
	
	private EventoDetail eventoDetail;
	private float prezzo;
	
	public void setIdEventoDetail(int id) {
		
		if(eventoDetail == null) {
			eventoDetail = new EventoDetail();
		}
		eventoDetail.setId(id);
		
	}
	
	public int getIdEventoDetail() {
		return eventoDetail.getId();
	}
	
	public EventoDetail getEventoDetail() {
		return eventoDetail;
	}
	public void setEventoDetail(EventoDetail eventoDetail) {
		this.eventoDetail = eventoDetail;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	

}
