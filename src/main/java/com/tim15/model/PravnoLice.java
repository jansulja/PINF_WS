/***********************************************************************
 * Module:  PravnoLice.java
 * Author:  Shuky
 * Purpose: Defines the Class PravnoLice
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "klijent_id")
public class PravnoLice extends Klijent {

	private java.lang.String naziv;
	private double maticniBroj;
	private double pib;
	private java.lang.String sifraPretezneDelatnosti;
	private java.lang.String klasifikacija;

	public PravnoLice() {
		super();
		// TODO Auto-generated constructor stub
	}


	public java.lang.String getNaziv() {
		return naziv;
	}

	public void setNaziv(java.lang.String naziv) {
		this.naziv = naziv;
	}

	public double getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(double maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public double getPib() {
		return pib;
	}

	public void setPib(double pib) {
		this.pib = pib;
	}

	public java.lang.String getSifraPretezneDelatnosti() {
		return sifraPretezneDelatnosti;
	}

	public void setSifraPretezneDelatnosti(java.lang.String sifraPretezneDelatnosti) {
		this.sifraPretezneDelatnosti = sifraPretezneDelatnosti;
	}

	public java.lang.String getKlasifikacija() {
		return klasifikacija;
	}

	public void setKlasifikacija(java.lang.String klasifikacija) {
		this.klasifikacija = klasifikacija;
	}

	@Override
	public String toString() {
		return "PravnoLice [naziv=" + naziv + ", maticniBroj=" + maticniBroj + ", pib=" + pib
				+ ", sifraPretezneDelatnosti=" + sifraPretezneDelatnosti + ", klasifikacija=" + klasifikacija
				+ ", toString()=" + super.toString() + "]";
	}

	public void setAll(PravnoLice pravnoLice) {
		super.setTelefon(pravnoLice.getTelefon());
		super.setAdresa(pravnoLice.getAdresa());
		super.setEmail(pravnoLice.getEmail());
		super.setIdBanka(pravnoLice.getIdBanka());
		super.setTelefon(pravnoLice.getTelefon());
		this.klasifikacija = pravnoLice.klasifikacija;
		this.maticniBroj = pravnoLice.maticniBroj;
		this.naziv = pravnoLice.naziv;
		this.pib = pravnoLice.pib;
		this.sifraPretezneDelatnosti = pravnoLice.sifraPretezneDelatnosti;
	}

}