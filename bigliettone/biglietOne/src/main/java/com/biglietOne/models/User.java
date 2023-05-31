package com.biglietOne.models;

import java.sql.Date;
import java.util.List;

public class User extends Entity {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String email;
	private String username;
	private String password;
	private String eventiPreferiti;
	private String categoriePreferite;
	private Citta cittaUser;
	
	public void setIdCitta(int id) {
		if(cittaUser == null) {
			cittaUser = new Citta();
		}
		cittaUser.setId(id);
	}

	public int getIdCitta(){
		if(cittaUser != null){
			return cittaUser.getId();
		}
		return -1;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEventiPreferiti() {
		return eventiPreferiti;
	}
	public void setEventiPreferiti(String eventiPreferiti) {
		this.eventiPreferiti = eventiPreferiti;
	}
	public String getCategoriePreferite() {
		return categoriePreferite;
	}
	public void setCategoriePreferite(String categoriePreferite) {
		this.categoriePreferite = categoriePreferite;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	} 	
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Citta getCittaUser() {
		return cittaUser;
	}
	public void setCittaUser(Citta cittaUser) {
		this.cittaUser = cittaUser;
	}
	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", eventiPreferiti=" + eventiPreferiti
				+ ", categoriePreferite=" + categoriePreferite + ", cittaUser=" + cittaUser + "]";
	}
	
}
