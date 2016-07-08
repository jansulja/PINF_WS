/***********************************************************************
 * Module:  Ukidanje.java
 * Author:  Shuky
 * Purpose: Defines the Class Ukidanje
 ***********************************************************************/

package com.tim15.model;



import java.sql.Date;

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
public class Ukidanje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ukidanje_id", unique = true)
	private int ukidanjeId;
	private Date datumUkidanja;
	private java.lang.String sredstvaSePrenoseNaRacun;

	@ManyToOne(optional=false)
	@JoinColumn(name = "racuni_id")
	private Racuni racuni;

	public Ukidanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ukidanje(Date datumUkidanja, String sredstvaSePrenoseNaRacun, Racuni racuni) {
		super();
		this.datumUkidanja = datumUkidanja;
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
		this.racuni = racuni;
	}

	public int getUkidanjeId() {
		return ukidanjeId;
	}

	public void setUkidanjeId(int ukidanjeId) {
		this.ukidanjeId = ukidanjeId;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public java.lang.String getSredstvaSePrenoseNaRacun() {
		return sredstvaSePrenoseNaRacun;
	}

	public void setSredstvaSePrenoseNaRacun(java.lang.String sredstvaSePrenoseNaRacun) {
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
	}

	public Racuni getRacuni() {
		return racuni;
	}

	public void setRacuni(Racuni racuni) {
		this.racuni = racuni;
	}

}