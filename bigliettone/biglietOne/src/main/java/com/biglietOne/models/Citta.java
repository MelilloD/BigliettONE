package com.biglietOne.models;

import java.util.ArrayList;
import java.util.List;

public class Citta extends Entity{

	private String nomeCitta;
	private String provincia;
	private List<Location> listaLocation;

	public Citta(){
		listaLocation = new ArrayList<Location>();
	}

	public String getNomeCitta() {
		return nomeCitta;
	}

	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public List<Location> getListaLocation() {
		return listaLocation;
	}

	public void setListaLcoation(List<Location> listaEventi) {
		this.listaLocation = listaEventi;
	}
	
	
}
