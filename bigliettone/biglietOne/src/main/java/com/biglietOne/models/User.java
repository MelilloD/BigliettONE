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
	@Override
	public String toString() {
		return "User [toString()=" + super.toString() + ", email=" + email + ", username=" + username + ", password="
				+ password +", nome="+ nome +", cognome="+cognome+", data di nascita="+ dataNascita+", eventi preferiti="
				+eventiPreferiti +", Categorie preferite="+ categoriePreferite +"]";
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
}
