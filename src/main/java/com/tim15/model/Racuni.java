/***********************************************************************
 * Module:  Racuni.java
 * Author:  Shuky
 * Purpose: Defines the Class Racuni
 ***********************************************************************/

package com.tim15.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Entity
public class Racuni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "racuni_id", unique = true)
	private long idRacuna;
	private java.lang.String brojRacuna;
	private java.util.Date datumOtvaranja;
	private boolean vazeci = false;
	private double stanje;

	@ManyToOne
	@JoinColumn(name = "klijent_id")
	@JsonBackReference
	private Klijent klijent;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "racuni", cascade = CascadeType.ALL)
	@JsonManagedReference
	private java.util.Collection<DnevnoStanjeRacuna> dnevnoStanjeRacuna;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "racuni", cascade = CascadeType.ALL)
	@JsonManagedReference
	private java.util.Collection<Ukidanje> ukidanje;

	@ManyToOne
	@JoinColumn(name = "banka_id")
	@JsonBackReference
	private Banka banka;

	@ManyToOne
	@JoinColumn(name="valuta_id")
	@JsonBackReference
	private Valuta valuta;

	public Racuni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Racuni(String brojRacuna, Date datumOtvaranja, boolean vazeci, Klijent klijent, Banka banka, double stanje) {
		super();
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.klijent = klijent;
		this.banka = banka;
		this.stanje = stanje;

	}

	public long getIdRacuna() {
		return idRacuna;
	}

	public void setIdRacuna(long idRacuna) {
		this.idRacuna = idRacuna;
	}

	public java.lang.String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(java.lang.String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public java.util.Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(java.util.Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public void addFunds(double funds){

		this.stanje += funds;

	}

	/** @pdGenerated default getter */
	public java.util.Collection<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDnevnoStanjeRacuna
	 */
	public void setDnevnoStanjeRacuna(java.util.Collection<DnevnoStanjeRacuna> newDnevnoStanjeRacuna) {
		removeAllDnevnoStanjeRacuna();
		for (java.util.Iterator iter = newDnevnoStanjeRacuna.iterator(); iter.hasNext();)
			addDnevnoStanjeRacuna((DnevnoStanjeRacuna) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDnevnoStanjeRacuna
	 */
	public void addDnevnoStanjeRacuna(DnevnoStanjeRacuna newDnevnoStanjeRacuna) {
		if (newDnevnoStanjeRacuna == null)
			return;
		if (this.dnevnoStanjeRacuna == null)
			this.dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		if (!this.dnevnoStanjeRacuna.contains(newDnevnoStanjeRacuna))
			this.dnevnoStanjeRacuna.add(newDnevnoStanjeRacuna);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDnevnoStanjeRacuna
	 */
	public void removeDnevnoStanjeRacuna(DnevnoStanjeRacuna oldDnevnoStanjeRacuna) {
		if (oldDnevnoStanjeRacuna == null)
			return;
		if (this.dnevnoStanjeRacuna != null)
			if (this.dnevnoStanjeRacuna.contains(oldDnevnoStanjeRacuna))
				this.dnevnoStanjeRacuna.remove(oldDnevnoStanjeRacuna);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna != null)
			dnevnoStanjeRacuna.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Ukidanje> getUkidanje() {
		if (ukidanje == null)
			ukidanje = new java.util.HashSet<Ukidanje>();
		return ukidanje;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorUkidanje() {
		if (ukidanje == null)
			ukidanje = new java.util.HashSet<Ukidanje>();
		return ukidanje.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newUkidanje
	 */
	public void setUkidanje(java.util.Collection<Ukidanje> newUkidanje) {
		removeAllUkidanje();
		for (java.util.Iterator iter = newUkidanje.iterator(); iter.hasNext();)
			addUkidanje((Ukidanje) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newUkidanje
	 */
	public void addUkidanje(Ukidanje newUkidanje) {
		if (newUkidanje == null)
			return;
		if (this.ukidanje == null)
			this.ukidanje = new java.util.HashSet<Ukidanje>();
		if (!this.ukidanje.contains(newUkidanje))
			this.ukidanje.add(newUkidanje);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldUkidanje
	 */
	public void removeUkidanje(Ukidanje oldUkidanje) {
		if (oldUkidanje == null)
			return;
		if (this.ukidanje != null)
			if (this.ukidanje.contains(oldUkidanje))
				this.ukidanje.remove(oldUkidanje);
	}

	/** @pdGenerated default removeAll */
	public void removeAllUkidanje() {
		if (ukidanje != null)
			ukidanje.clear();
	}

}