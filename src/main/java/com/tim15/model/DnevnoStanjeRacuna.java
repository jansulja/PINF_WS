/***********************************************************************
 * Module:  DnevnoStanjeRacuna.java
 * Author:  Shuky
 * Purpose: Defines the Class DnevnoStanjeRacuna
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class DnevnoStanjeRacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dnevno_stanje_racuna_id", unique = true)
	private long dnevnoStanjeRacunaId;
	private java.util.Date datumPrometa;
	private double prethodnoStanje = 0;
	private double prometUKorist = 0;
	private double prometNaTeret = 0;
	private double novoStanje = 0;

	@ManyToOne
	@JoinColumn(name = "racuni_id")
	@JsonBackReference(value="racuniDnevnoStanjeRacuna")
	private Racuni racuni;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dnevnoStanjeRacuna", cascade = CascadeType.ALL)
	@JsonManagedReference(value="dnevnoStanjeRacunaAnalitikaIzvoda")
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<AnalitikaIzvoda> analitikaIzvoda;

	public DnevnoStanjeRacuna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnevnoStanjeRacuna(Date datumPrometa, double prethodnoStanje, double prometUKorist, double prometNaTeret,
			double novoStanje, Racuni racuni, Collection<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.datumPrometa = datumPrometa;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUKorist = prometUKorist;
		this.prometNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.racuni = racuni;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public long getDnevnoStanjeRacunaId() {
		return dnevnoStanjeRacunaId;
	}

	public void setDnevnoStanjeRacunaId(long dnevnoStanjeRacunaId) {
		this.dnevnoStanjeRacunaId = dnevnoStanjeRacunaId;
	}

	public java.util.Date getDatumPrometa() {
		return datumPrometa;
	}

	public void setDatumPrometa(java.util.Date datumPrometa) {
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

	/** @pdGenerated default getter */
	public java.util.Collection<AnalitikaIzvoda> getAnalitikaIzvoda() {
		if (analitikaIzvoda == null)
			analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
		return analitikaIzvoda;
	}

	/** @pdGenerated default iterator getter */
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

}