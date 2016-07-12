/***********************************************************************
 * Module:  VrstePlacanja.java
 * Author:  Shuky
 * Purpose: Defines the Class VrstePlacanja
 ***********************************************************************/

package com.tim15.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VrstePlacanja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vrstaplacanja_id", unique = true)
	private int vrstaPlacanjaId;
	private java.lang.String nazivVrstePlacanja;
	private int oznaka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vrstePlacanja", orphanRemoval=true)
	@JsonIgnore
	private Set<AnalitikaIzvoda> analitikaIzvoda;

	public VrstePlacanja() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VrstePlacanja(int vrstaPlacanjaId, String nazivVrstePlacanja, int oznaka,
			Set<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.vrstaPlacanjaId = vrstaPlacanjaId;
		this.nazivVrstePlacanja = nazivVrstePlacanja;
		this.oznaka = oznaka;
		this.analitikaIzvoda = analitikaIzvoda;
	}



	public int getOznaka() {
		return oznaka;
	}



	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}



	public int getVrstaPlacanjaId() {
		return vrstaPlacanjaId;
	}

	public void setVrstaPlacanjaId(int vrstaPlacanjaId) {
		this.vrstaPlacanjaId = vrstaPlacanjaId;
	}

	public java.lang.String getNazivVrstePlacanja() {
		return nazivVrstePlacanja;
	}

	public void setNazivVrstePlacanja(java.lang.String nazivVrstePlacanja) {
		this.nazivVrstePlacanja = nazivVrstePlacanja;
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
	public void setAnalitikaIzvoda(Set<AnalitikaIzvoda> newAnalitikaIzvoda) {
//		removeAllAnalitikaIzvoda();
//		for (java.util.Iterator iter = newAnalitikaIzvoda.iterator(); iter.hasNext();)
//			addAnalitikaIzvoda((AnalitikaIzvoda) iter.next());
		analitikaIzvoda = newAnalitikaIzvoda;
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