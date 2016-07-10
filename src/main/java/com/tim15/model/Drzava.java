/***********************************************************************
 * Module:  Drzava.java
 * Author:  Shuky
 * Purpose: Defines the Class Drzava
 ***********************************************************************/

package com.tim15.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="drzavaId" ,scope=Drzava.class)
public class Drzava implements Serializable{


	private static final long serialVersionUID = 4224465156285553609L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drzava_id", unique = true)
	private int drzavaId;
	private java.lang.String nazivDrzave;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drzava",orphanRemoval=true)
	private java.util.Collection<Valuta> valuta;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drzava",orphanRemoval=true)
	private Set<NaseljenoMesto> naseljenoMesto;





	public Drzava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drzava(int drzavaId,String nazivDrzave, Collection<Valuta> valuta, Set<NaseljenoMesto> naseljenoMesto) {
		super();
		this.drzavaId = drzavaId;
		this.nazivDrzave = nazivDrzave;
		this.valuta = valuta;
		this.naseljenoMesto = naseljenoMesto;
	}

	public int getDrzavaId() {
		return drzavaId;
	}

	public void setDrzavaId(int drzavaId) {
		this.drzavaId = drzavaId;
	}

	public java.lang.String getNazivDrzave() {
		return nazivDrzave;
	}

	public void setNazivDrzave(java.lang.String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}

	/**
	 * @pdRoleInfo migr=no name=Valuta assc=drzavnaValuta
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */

	@JsonIgnore
	public java.util.Collection<Valuta> getValuta() {
		if (valuta == null)
			valuta = new java.util.HashSet<Valuta>();
		return valuta;
	}

	/** @pdGenerated default iterator getter */
	@JsonIgnore
	public java.util.Iterator getIteratorValuta() {
		if (valuta == null)
			valuta = new java.util.HashSet<Valuta>();
		return valuta.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newValuta
	 */
	@JsonIgnore
	public void setValuta(java.util.Collection<Valuta> newValuta) {
		removeAllValuta();
		for (java.util.Iterator iter = newValuta.iterator(); iter.hasNext();)
			addValuta((Valuta) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newValuta
	 */
	public void addValuta(Valuta newValuta) {
		if (newValuta == null)
			return;
		if (this.valuta == null)
			this.valuta = new java.util.HashSet<Valuta>();
		if (!this.valuta.contains(newValuta))
			this.valuta.add(newValuta);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldValuta
	 */
	public void removeValuta(Valuta oldValuta) {
		if (oldValuta == null)
			return;
		if (this.valuta != null)
			if (this.valuta.contains(oldValuta))
				this.valuta.remove(oldValuta);
	}

	/** @pdGenerated default removeAll */
	public void removeAllValuta() {
		if (valuta != null)
			valuta.clear();
	}

	@JsonIgnore
	public java.util.Collection<NaseljenoMesto> getNaseljenoMesto() {
		if (naseljenoMesto == null)
			naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		return naseljenoMesto;
	}

	/** @pdGenerated default iterator getter */
	@JsonIgnore
	public java.util.Iterator getIteratorNaseljenoMesto() {
		if (naseljenoMesto == null)
			naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		return naseljenoMesto.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newNaseljenoMesto
	 */
	@JsonIgnore
	public void setNaseljenoMesto(java.util.Collection<NaseljenoMesto> newNaseljenoMesto) {
		removeAllNaseljenoMesto();
		for (java.util.Iterator iter = newNaseljenoMesto.iterator(); iter.hasNext();)
			addNaseljenoMesto((NaseljenoMesto) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newNaseljenoMesto
	 */

	public void addNaseljenoMesto(NaseljenoMesto newNaseljenoMesto) {
		if (newNaseljenoMesto == null)
			return;
		if (this.naseljenoMesto == null)
			this.naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		if (!this.naseljenoMesto.contains(newNaseljenoMesto))
			this.naseljenoMesto.add(newNaseljenoMesto);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNaseljenoMesto
	 */
	public void removeNaseljenoMesto(NaseljenoMesto oldNaseljenoMesto) {
		if (oldNaseljenoMesto == null)
			return;
		if (this.naseljenoMesto != null)
			if (this.naseljenoMesto.contains(oldNaseljenoMesto))
				this.naseljenoMesto.remove(oldNaseljenoMesto);
	}

	/** @pdGenerated default removeAll */
	public void removeAllNaseljenoMesto() {
		if (naseljenoMesto != null)
			naseljenoMesto.clear();
	}



}