/***********************************************************************
 * Module:  NaseljenoMesto.java
 * Author:  Shuky
 * Purpose: Defines the Class NaseljenoMesto
 ***********************************************************************/

package com.tim15.model;

import java.io.Serializable;
import java.util.Collection;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="naseljenoMestoId",scope=NaseljenoMesto.class)
public class NaseljenoMesto implements Serializable{

	private static final long serialVersionUID = 1879487028154453181L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "naseljenomesto_id", unique = true)
	private int naseljenoMestoId;
	private java.lang.String naziv;
	private java.lang.String pTToznaka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "naseljenoMesto", orphanRemoval=true)
	@JsonIgnore
	private Set<AnalitikaIzvoda> analitikaIzvoda;

	@ManyToOne(optional=false)
	@JoinColumn(name = "drzava_id")
	private Drzava drzava;

	public NaseljenoMesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaseljenoMesto(int naseljenoMestoId, String naziv, String pTToznaka, Set<AnalitikaIzvoda> analitikaIzvoda, Drzava drzava) {
		super();
		this.naseljenoMestoId = naseljenoMestoId;
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
	@JsonInclude
	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	@JsonIgnore
	public java.util.Collection<AnalitikaIzvoda> getAnalitikaIzvoda() {
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

}