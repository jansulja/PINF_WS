/***********************************************************************
 * Module:  KursnaLista.java
 * Author:  Shuky
 * Purpose: Defines the Class KursnaLista
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
public class KursnaLista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kursnalista_id", unique = true)
	private int kursnaListaId;
	private java.util.Date datum;
	private double brojKursneListe;
	private java.util.Date primenjujeSeOd;

	@ManyToOne
	@JoinColumn(name = "banka_id")
	@JsonBackReference
	private Banka banka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "kursnaLista", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<KursUValuti> kursUValuti;

	public KursnaLista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursnaLista(Date datum, double brojKursneListe, Date primenjujeSeOd, Banka banka,
			Collection<KursUValuti> kursUValuti) {
		super();
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
		this.kursUValuti = kursUValuti;
	}

	public int getKursnaListaId() {
		return kursnaListaId;
	}

	public void setKursnaListaId(int kursnaListaId) {
		this.kursnaListaId = kursnaListaId;
	}

	public java.util.Date getDatum() {
		return datum;
	}

	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}

	public double getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(double brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public java.util.Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(java.util.Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<KursUValuti> getKursUValuti() {
		if (kursUValuti == null)
			kursUValuti = new java.util.HashSet<KursUValuti>();
		return kursUValuti;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorKursUValuti() {
		if (kursUValuti == null)
			kursUValuti = new java.util.HashSet<KursUValuti>();
		return kursUValuti.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newKursUValuti
	 */
	public void setKursUValuti(java.util.Collection<KursUValuti> newKursUValuti) {
		removeAllKursUValuti();
		for (java.util.Iterator iter = newKursUValuti.iterator(); iter.hasNext();)
			addKursUValuti((KursUValuti) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newKursUValuti
	 */
	public void addKursUValuti(KursUValuti newKursUValuti) {
		if (newKursUValuti == null)
			return;
		if (this.kursUValuti == null)
			this.kursUValuti = new java.util.HashSet<KursUValuti>();
		if (!this.kursUValuti.contains(newKursUValuti))
			this.kursUValuti.add(newKursUValuti);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldKursUValuti
	 */
	public void removeKursUValuti(KursUValuti oldKursUValuti) {
		if (oldKursUValuti == null)
			return;
		if (this.kursUValuti != null)
			if (this.kursUValuti.contains(oldKursUValuti))
				this.kursUValuti.remove(oldKursUValuti);
	}

	/** @pdGenerated default removeAll */
	public void removeAllKursUValuti() {
		if (kursUValuti != null)
			kursUValuti.clear();
	}

}