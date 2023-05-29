package com.biglietOne.models;

public class Location extends Entity{
	
	private String nomeLocation;
	private String tipologiaLocation;

	private Citta citta;
	
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

	public void setCitta(Citta citta) {
		this.citta = citta;
	}
	
	public Citta getCitta() {
		return citta;
	}

	public void setIdCitta(int id){
		if(citta == null){
			citta = new Citta();
		}
		citta.setId(id);
	}

	public int getIdCitta(){
		return citta.getId();
	}
	

}
