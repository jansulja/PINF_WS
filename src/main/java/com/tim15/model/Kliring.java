package com.tim15.model;

import java.sql.Timestamp;
import java.util.Date;
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
public class Kliring {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kliring_id", unique = true)
	private int kliringId;
	private java.sql.Timestamp datumKliringa;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "kliring", orphanRemoval = true)
	@JsonIgnore
	private java.util.Set<StavkaKliringa> stavkaKliringa;





	public Kliring(int kliringId, Timestamp datumKliringa, Set<StavkaKliringa> stavkaKliringa) {
		super();
		this.kliringId = kliringId;
		this.datumKliringa = datumKliringa;
		this.stavkaKliringa = stavkaKliringa;
	}

	public Kliring() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getKliringId() {
		return kliringId;
	}

	public void setKliringId(int kliringId) {
		this.kliringId = kliringId;
	}

	public Timestamp getDatumKliringa() {
		return datumKliringa;
	}

	public void setDatumKliringa(Timestamp datumKliringa) {
		this.datumKliringa = datumKliringa;
	}

	@JsonIgnore
	public java.util.Set<StavkaKliringa> getStavkaKliringa() {
		if (stavkaKliringa == null)
			stavkaKliringa = new java.util.HashSet<StavkaKliringa>();
		return stavkaKliringa;
	}

	@SuppressWarnings("rawtypes")
	@JsonIgnore
	public java.util.Iterator getIteratorStavkaKliringa() {
		if (stavkaKliringa == null)
			stavkaKliringa = new java.util.HashSet<StavkaKliringa>();
		return stavkaKliringa.iterator();
	}

	public void setStavkaKliringa(java.util.Set<StavkaKliringa> newStavkaKliringa) {
		removeAllStavkaKliringa();
		for (@SuppressWarnings("rawtypes")
		java.util.Iterator iter = newStavkaKliringa.iterator(); iter.hasNext();)
			addStavkaKliringa((StavkaKliringa) iter.next());
	}

	public void addStavkaKliringa(StavkaKliringa newStavkaKliringa) {
		if (newStavkaKliringa == null)
			return;
		if (this.stavkaKliringa == null)
			this.stavkaKliringa = new java.util.HashSet<StavkaKliringa>();
		if (!this.stavkaKliringa.contains(newStavkaKliringa))
			this.stavkaKliringa.add(newStavkaKliringa);
	}

	public void removeStavkaKliringa(StavkaKliringa oldStavkaKliringa) {
		if (oldStavkaKliringa == null)
			return;
		if (this.stavkaKliringa != null)
			if (this.stavkaKliringa.contains(oldStavkaKliringa))
				this.stavkaKliringa.remove(oldStavkaKliringa);
	}

	public void removeAllStavkaKliringa() {
		if (stavkaKliringa != null)
			stavkaKliringa.clear();
	}

}
