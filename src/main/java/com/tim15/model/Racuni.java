/***********************************************************************
 * Module:  Racuni.java
 * Author:  Shuky
 * Purpose: Defines the Class Racuni
 ***********************************************************************/

package com.tim15.model;

import java.sql.Date;
import java.util.Set;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Racuni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "racuni_id", unique = true)
	private int racuniId;
	private java.lang.String brojRacuna;
	private Date datumOtvaranja;
	private boolean vazeci = false;
	private double stanje;

	@ManyToOne(optional=false)
	@JoinColumn(name = "klijent_id")
	private Klijent klijent;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "racuni", orphanRemoval=true)
	@JsonIgnore
	private Set<DnevnoStanjeRacuna> dnevnoStanjeRacuna;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "racuni", orphanRemoval=true)
	@JsonIgnore
	private Set<Ukidanje> ukidanje;

	@ManyToOne(optional=false)
	@JoinColumn(name = "banka_id")
	private Banka banka;

	@ManyToOne(optional=false)
	@JoinColumn(name="valuta_id")
	//@JsonBackReference(value="valutaRacuni")
	private Valuta valuta;

	public Racuni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Racuni(int racuniId,String brojRacuna, Date datumOtvaranja, boolean vazeci, Klijent klijent, Banka banka, double stanje) {
		super();
		this.racuniId = racuniId;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.klijent = klijent;
		this.banka = banka;
		this.stanje = stanje;

	}



	public int getRacuniId() {
		return racuniId;
	}

	public void setRacuniId(int racuniId) {
		this.racuniId = racuniId;
	}

	public java.lang.String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(java.lang.String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
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

	@JsonIgnore
	public java.util.Collection<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna;
	}

	@JsonIgnore
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

	@JsonIgnore
	public java.util.Collection<Ukidanje> getUkidanje() {
		if (ukidanje == null)
			ukidanje = new java.util.HashSet<Ukidanje>();
		return ukidanje;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	@JsonIgnore
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

	public void setAll(String brojRacuna, Date datumOtvaranja, boolean vazeci, double stanje, Klijent klijent, Banka banka, Valuta valuta) {

		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.stanje = stanje;
		this.klijent = klijent;
		this.banka = banka;
		this.valuta = valuta;
	}

	@JsonIgnore
	public double getStanjeRacuna(){

		double stanje = 0;

		if(dnevnoStanjeRacuna!=null && !dnevnoStanjeRacuna.isEmpty()){

			DnevnoStanjeRacuna poslednje = null;

			for(DnevnoStanjeRacuna dsr : dnevnoStanjeRacuna){
				poslednje = dsr;
				break;

			}

			for(DnevnoStanjeRacuna dsr : dnevnoStanjeRacuna){

				Date trenutno = new Date(dsr.getDatumPrometa().getTime());
				Date posl = new Date(poslednje.getDatumPrometa().getTime());

				if(trenutno.after(posl)){

					poslednje = dsr;
				}

			}

			stanje = poslednje.getNovoStanje();



		}



		return stanje;

	}


}