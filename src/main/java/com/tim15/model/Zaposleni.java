package com.tim15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Zaposleni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zaposleni_id", unique = true)
	private int zaposleniId;
	private String ime;
	private String prezime;
	private String email;
	private String password;

	@ManyToOne(optional=false)
	@JoinColumn(name = "banka_id")
	private Banka banka;

	public Zaposleni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zaposleni(int zaposleniId, String ime, String prezime, String email, String password, Banka banka) {
		super();
		this.zaposleniId = zaposleniId;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
		this.banka = banka;
	}

	public int getZaposleniId() {
		return zaposleniId;
	}

	public void setZaposleniId(int zaposleniId) {
		this.zaposleniId = zaposleniId;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}



}
