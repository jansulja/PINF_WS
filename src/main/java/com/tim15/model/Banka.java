/***********************************************************************
 * Module:  Banka.java
 * Author:  Shuky
 * Purpose: Defines the Class Banka
 ***********************************************************************/

package com.tim15.model;

import java.util.Collection;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Banka {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banka_id", unique = true)
	private int bankaId;
	private java.lang.String sifraBanke;
	private java.lang.String pib;
	private java.lang.String naziv;
	private java.lang.String adresa;
	private java.lang.String eMail;
	private java.lang.String web;
	private java.lang.String telefon;
	private java.lang.String fax;
	private boolean banka;


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka", cascade = CascadeType.ALL)
	@JsonManagedReference(value="bankaRacuni")
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<Racuni> racuni;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka", cascade = CascadeType.ALL)
	@JsonManagedReference(value="bankaKursnaLista")
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<KursnaLista> kursnaLista;





	public Banka() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Banka(String sifraBanke, String pib, String naziv, String adresa, String eMail, String web, String telefon,
			String fax, boolean banka, Collection<Racuni> racuni, Collection<KursnaLista> kursnaLista) {
		super();
		this.sifraBanke = sifraBanke;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.eMail = eMail;
		this.web = web;
		this.telefon = telefon;
		this.fax = fax;
		this.banka = banka;
		this.racuni = racuni;
		this.kursnaLista = kursnaLista;
	}



	public int getBankaId() {
		return bankaId;
	}

	public void setBankaId(int bankaId) {
		this.bankaId = bankaId;
	}

	public java.lang.String getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(java.lang.String sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public java.lang.String getPib() {
		return pib;
	}

	public void setPib(java.lang.String pib) {
		this.pib = pib;
	}

	public java.lang.String getNaziv() {
		return naziv;
	}

	public void setNaziv(java.lang.String naziv) {
		this.naziv = naziv;
	}

	public java.lang.String getAdresa() {
		return adresa;
	}

	public void setAdresa(java.lang.String adresa) {
		this.adresa = adresa;
	}

	public java.lang.String geteMail() {
		return eMail;
	}

	public void seteMail(java.lang.String eMail) {
		this.eMail = eMail;
	}

	public java.lang.String getWeb() {
		return web;
	}

	public void setWeb(java.lang.String web) {
		this.web = web;
	}

	public java.lang.String getTelefon() {
		return telefon;
	}

	public void setTelefon(java.lang.String telefon) {
		this.telefon = telefon;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public boolean isBanka() {
		return banka;
	}

	public void setBanka(boolean banka) {
		this.banka = banka;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Racuni> getRacuni() {
		if (racuni == null)
			racuni = new java.util.HashSet<Racuni>();
		return racuni;
	}

	/** @pdGenerated default iterator getter */
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

	/** @pdGenerated default getter */
	public java.util.Collection<KursnaLista> getKursnaLista() {
		if (kursnaLista == null)
			kursnaLista = new java.util.HashSet<KursnaLista>();
		return kursnaLista;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorKursnaLista() {
		if (kursnaLista == null)
			kursnaLista = new java.util.HashSet<KursnaLista>();
		return kursnaLista.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newKursnaLista
	 */
	public void setKursnaLista(java.util.Collection<KursnaLista> newKursnaLista) {
		removeAllKursnaLista();
		for (java.util.Iterator iter = newKursnaLista.iterator(); iter.hasNext();)
			addKursnaLista((KursnaLista) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newKursnaLista
	 */
	public void addKursnaLista(KursnaLista newKursnaLista) {
		if (newKursnaLista == null)
			return;
		if (this.kursnaLista == null)
			this.kursnaLista = new java.util.HashSet<KursnaLista>();
		if (!this.kursnaLista.contains(newKursnaLista))
			this.kursnaLista.add(newKursnaLista);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldKursnaLista
	 */
	public void removeKursnaLista(KursnaLista oldKursnaLista) {
		if (oldKursnaLista == null)
			return;
		if (this.kursnaLista != null)
			if (this.kursnaLista.contains(oldKursnaLista))
				this.kursnaLista.remove(oldKursnaLista);
	}

	/** @pdGenerated default removeAll */
	public void removeAllKursnaLista() {
		if (kursnaLista != null)
			kursnaLista.clear();
	}

}