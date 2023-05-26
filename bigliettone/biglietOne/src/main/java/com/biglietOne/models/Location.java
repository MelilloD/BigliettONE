package com.biglietOne.models;

public class Location extends Entity{
	
	private String nomeLocation;
	private String tipologiaLocation;
	
	private String indirizzo;
	private int capienza;
	private String indicazioniStradali;
	
	
	
	
	public String getNomeLocation() {
		return nomeLocation;
	}
	public void setNomeLocation(String nomeLocation) {
		this.nomeLocation = nomeLocation;
	}
	public String getTipologiaLocation() {
		return tipologiaLocation;
	}
	public void setTipologiaLocation(String tipologiaLocation) {
		this.tipologiaLocation = tipologiaLocation;
	}
	
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public String getIndicazioniStradali() {
		return indicazioniStradali;
	}
	public void setIndicazioniStradali(String indicazioniStradali) {
		this.indicazioniStradali = indicazioniStradali;
	}
	
	

}
