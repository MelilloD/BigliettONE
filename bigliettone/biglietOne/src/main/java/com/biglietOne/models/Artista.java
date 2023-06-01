package com.biglietOne.models;

public class Artista extends Entity{

	private String nomeArtista;
	private String infArtista;
	private String foto;
	
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	public String getInfArtista() {
		return infArtista;
	}
	public void setInfArtista(String infArtista) {
		this.infArtista = infArtista;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
