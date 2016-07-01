/***********************************************************************
 * Module:  NaseljenoMesto.java
 * Author:  Shuky
 * Purpose: Defines the Class NaseljenoMesto
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

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

public class NaseljenoMesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "naseljenomesto_id", unique = true)
	private int naseljenoMestoId;
	private java.lang.String naziv;
	private java.lang.String pTToznaka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "naseljenoMesto", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<AnalitikaIzvoda> analitikaIzvoda;

	@ManyToOne
	@JoinColumn(name = "drzava_id")
	@JsonBackReference
	private Drzava drzava;

	public NaseljenoMesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaseljenoMesto(String naziv, String pTToznaka, Collection<AnalitikaIzvoda> analitikaIzvoda, Drzava drzava) {
		super();
		this.naziv = naziv;
		this.pTToznaka = pTToznaka;
		this.analitikaIzvoda = analitikaIzvoda;
		this.drzava = drzava;
	}

	public int getNaseljenoMestoId() {
		return naseljenoMestoId;
	}

	public void setNaseljenoMestoId(int naseljenoMestoId) {
		this.naseljenoMestoId = naseljenoMestoId;
	}

	public java.lang.String getNaziv() {
		return naziv;
	}

	public void setNaziv(java.lang.String naziv) {
		this.naziv = naziv;
	}

	public java.lang.String getpTToznaka() {
		return pTToznaka;
	}

	public void setpTToznaka(java.lang.String pTToznaka) {
		this.pTToznaka = pTToznaka;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
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