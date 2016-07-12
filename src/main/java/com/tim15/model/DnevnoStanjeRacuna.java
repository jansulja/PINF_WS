/***********************************************************************
 * Module:  DnevnoStanjeRacuna.java
 * Author:  Shuky
 * Purpose: Defines the Class DnevnoStanjeRacuna
 ***********************************************************************/

package com.tim15.model;


import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DnevnoStanjeRacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dnevno_stanje_racuna_id", unique = true)
	private int dnevnoStanjeRacunaId;
	private Date datumPrometa;
	private double prethodnoStanje = 0;
	private double prometUKorist = 0;
	private double prometNaTeret = 0;
	private double novoStanje = 0;

	@ManyToOne(optional=false)
	@JoinColumn(name = "racuni_id")
	private Racuni racuni;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dnevnoStanjeRacuna", orphanRemoval=true)
	private Set<AnalitikaIzvoda> analitikaIzvoda;

	public DnevnoStanjeRacuna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnevnoStanjeRacuna(Date datumPrometa, double prethodnoStanje, double prometUKorist, double prometNaTeret,
			double novoStanje, Racuni racuni, Set<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.datumPrometa = datumPrometa;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUKorist = prometUKorist;
		this.prometNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.racuni = racuni;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public int getDnevnoStanjeRacunaId() {
		return dnevnoStanjeRacunaId;
	}

	public void setDnevnoStanjeRacunaId(int dnevnoStanjeRacunaId) {
		this.dnevnoStanjeRacunaId = dnevnoStanjeRacunaId;
	}

	public Date getDatumPrometa() {
		return datumPrometa;
	}

	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}

	public double getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(double prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public double getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(double prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public double getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(double prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public double getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(double novoStanje) {
		this.novoStanje = novoStanje;
	}

	public Racuni getRacuni() {
		return racuni;
	}

	public void setRacuni(Racuni racuni) {
		this.racuni = racuni;
	}

	@JsonIgnore
	public Set<AnalitikaIzvoda> getAnalitikaIzvoda() {
		if (analitikaIzvoda == null)
			analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
		return analitikaIzvoda;
	}

	@JsonIgnore
	public java.util.Iterator getIteratorAnalitikaIzvoda() {
		if (analitikaIzvoda == null)
			analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
		return analitikaIzvoda.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAnalitikaIzvoda
	 */
	public void setAnalitikaIzvoda(java.util.Collection<AnalitikaIzvoda> newAnalitikaIzvoda) {
		removeAllAnalitikaIzvoda();
		for (java.util.Iterator iter = newAnalitikaIzvoda.iterator(); iter.hasNext();)
			addAnalitikaIzvoda((AnalitikaIzvoda) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newAnalitikaIzvoda
	 */
	public void addAnalitikaIzvoda(AnalitikaIzvoda newAnalitikaIzvoda) {
		if (newAnalitikaIzvoda == null)
			return;
		if (this.analitikaIzvoda == null)
			this.analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
		if (!this.analitikaIzvoda.contains(newAnalitikaIzvoda))
			this.analitikaIzvoda.add(newAnalitikaIzvoda);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldAnalitikaIzvoda
	 */
	public void removeAnalitikaIzvoda(AnalitikaIzvoda oldAnalitikaIzvoda) {
		if (oldAnalitikaIzvoda == null)
			return;
		if (this.analitikaIzvoda != null)
			if (this.analitikaIzvoda.contains(oldAnalitikaIzvoda))
				this.analitikaIzvoda.remove(oldAnalitikaIzvoda);
	}

	/** @pdGenerated default removeAll */
	public void removeAllAnalitikaIzvoda() {
		if (analitikaIzvoda != null)
			analitikaIzvoda.clear();
	}

	public void setAll(DnevnoStanjeRacuna dnevnoStanjeRacuna){

		this.datumPrometa = dnevnoStanjeRacuna.datumPrometa;
		this.novoStanje = dnevnoStanjeRacuna.novoStanje;
		this.prethodnoStanje = dnevnoStanjeRacuna.prethodnoStanje;
		this.prometNaTeret = dnevnoStanjeRacuna.prometNaTeret;
		this.prometUKorist = dnevnoStanjeRacuna.prometUKorist;
		this.racuni = dnevnoStanjeRacuna.racuni;
	}

}