/***********************************************************************
 * Module:  Valuta.java
 * Author:  Shuky
 * Purpose: Defines the Class Valuta
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
import javax.persistence.Transient;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
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
public class Valuta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "valuta_id", unique = true)
	private int valutaId;
	private java.lang.String zvanicnaSifra;
	private java.lang.String naziv;
	private boolean domicilna = false;

	@ManyToOne(optional=false)
	@JoinColumn(name = "drzava_id")
	private Drzava drzava;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valutaOsnovna", orphanRemoval=true)
	@JsonIgnore
	private Set<KursUValuti> kursUValutiOsnovna;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valutaPrema", orphanRemoval=true)
	@JsonIgnore
	private Set<KursUValuti> kursUValutiPrema;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valuta", orphanRemoval=true)
	@JsonIgnore
	private Set<Racuni> racuni;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valuta", orphanRemoval=true)
	@JsonIgnore
	private Set<AnalitikaIzvoda> analitikaIzvoda;

	public Valuta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valuta(String zvanicnaSifra, String naziv, boolean domicilna, Drzava drzava,
			Set<KursUValuti> kursUValutiOsnovna, Set<KursUValuti> kursUValutiPrema,
			Set<Racuni> racuni, Set<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzava = drzava;
		this.kursUValutiOsnovna = kursUValutiOsnovna;
		this.kursUValutiPrema = kursUValutiPrema;
		this.racuni = racuni;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public int getValutaId() {
		return valutaId;
	}

	public void setValutaId(int valutaId) {
		this.valutaId = valutaId;
	}

	public java.lang.String getZvanicnaSifra() {
		return zvanicnaSifra;
	}

	public void setZvanicnaSifra(java.lang.String zvanicnaSifra) {
		this.zvanicnaSifra = zvanicnaSifra;
	}

	public java.lang.String getNaziv() {
		return naziv;
	}

	public void setNaziv(java.lang.String naziv) {
		this.naziv = naziv;
	}

	public boolean isDomicilna() {
		return domicilna;
	}

	public void setDomicilna(boolean domicilna) {
		this.domicilna = domicilna;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public java.util.Collection<KursUValuti> getKursUValutiOsnovna() {
		return kursUValutiOsnovna;
	}

	public void setKursUValutiOsnovna(Set<KursUValuti> kursUValutiOsnovna) {
		this.kursUValutiOsnovna = kursUValutiOsnovna;
	}

	public java.util.Collection<KursUValuti> getKursUValutiPrema() {
		return kursUValutiPrema;
	}

	public void setKursUValutiPrema(Set<KursUValuti> kursUValutiPrema) {
		this.kursUValutiPrema = kursUValutiPrema;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Racuni> getRacuni() {
		if (racuni == null)
			racuni = new java.util.HashSet<Racuni>();
		return racuni;
	}

	/** @pdGenerated default iterator getter */
	@JsonIgnore
	public java.util.Iterator getIteratorRacuni() {
		if (racuni == null)
			racuni = new java.util.HashSet<Racuni>();
		return racuni.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newRacuni
	 */
	public void setRacuni(java.util.Collection<Racuni> newRacuni) {
		removeAllRacuni();
		for (java.util.Iterator iter = newRacuni.iterator(); iter.hasNext();)
			addRacuni((Racuni) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newRacuni
	 */
	public void addRacuni(Racuni newRacuni) {
		if (newRacuni == null)
			return;
		if (this.racuni == null)
			this.racuni = new java.util.HashSet<Racuni>();
		if (!this.racuni.contains(newRacuni))
			this.racuni.add(newRacuni);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldRacuni
	 */
	public void removeRacuni(Racuni oldRacuni) {
		if (oldRacuni == null)
			return;
		if (this.racuni != null)
			if (this.racuni.contains(oldRacuni))
				this.racuni.remove(oldRacuni);
	}

	/** @pdGenerated default removeAll */
	public void removeAllRacuni() {
		if (racuni != null)
			racuni.clear();
	}

	@JsonIgnore
	public java.util.Collection<AnalitikaIzvoda> getAnalitikaIzvoda() {
		if (analitikaIzvoda == null)
			analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
		return analitikaIzvoda;
	}

	/** @pdGenerated default iterator getter */
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

	public void setAll(String zvanicnaSifra, String naziv, boolean domicilna, Drzava drzava) {

		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzava = drzava;

	}



}