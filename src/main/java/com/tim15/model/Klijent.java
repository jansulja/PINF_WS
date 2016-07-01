/***********************************************************************
 * Module:  Klijent.java
 * Author:  Shuky
 * Purpose: Defines the Class Klijent
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "klijent")
@Inheritance(strategy = InheritanceType.JOINED)
public class Klijent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "klijent_id", unique = true)
	private int klijentId;
	private java.lang.String telefon;
	private java.lang.String email;
	private java.lang.String adresa;
	private java.lang.String password;
	private Integer idBanka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "klijent", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<Racuni> racuni;

	public Klijent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Klijent(String telefon, String email, String adresa, String password, Integer idBanka,
			Collection<Racuni> racuni) {
		super();
		this.telefon = telefon;
		this.email = email;
		this.adresa = adresa;
		this.password = password;
		this.idBanka = idBanka;
		this.racuni = racuni;
	}

	public Integer getIdBanka() {
		return idBanka;
	}

	public void setIdBanka(Integer idBanka) {
		this.idBanka = idBanka;
	}

	public java.lang.String getTelefon() {
		return telefon;
	}

	public void setTelefon(java.lang.String telefon) {
		this.telefon = telefon;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getAdresa() {
		return adresa;
	}

	public void setAdresa(java.lang.String adresa) {
		this.adresa = adresa;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Klijent [idKlijenta=" + klijentId + ", telefon=" + telefon + ", email=" + email + ", adresa=" + adresa
				+ ", password=" + password + ", racuni=" + racuni + "]";
	}

	/** @pdGenerated default getter */
	// public java.util.Collection<Racuni> getRacuni() {
	// if (racuni == null)
	// racuni = new java.util.HashSet<Racuni>();
	// return racuni;
	// }
	//
	// /** @pdGenerated default iterator getter */
	// public java.util.Iterator getIteratorRacuni() {
	// if (racuni == null)
	// racuni = new java.util.HashSet<Racuni>();
	// return racuni.iterator();
	// }

	/**
	 * @pdGenerated default setter
	 * @param newRacuni
	 */
	// public void setRacuni(java.util.Collection<Racuni> newRacuni) {
	// removeAllRacuni();
	// for (java.util.Iterator iter = newRacuni.iterator(); iter.hasNext();)
	// addRacuni((Racuni)iter.next());
	// }

	/**
	 * @pdGenerated default add
	 * @param newRacuni
	 */
	// public void addRacuni(Racuni newRacuni) {
	// if (newRacuni == null)
	// return;
	// if (this.racuni == null)
	// this.racuni = new java.util.HashSet<Racuni>();
	// if (!this.racuni.contains(newRacuni))
	// this.racuni.add(newRacuni);
	// }
	//
	// /** @pdGenerated default remove
	// * @param oldRacuni */
	// public void removeRacuni(Racuni oldRacuni) {
	// if (oldRacuni == null)
	// return;
	// if (this.racuni != null)
	// if (this.racuni.contains(oldRacuni))
	// this.racuni.remove(oldRacuni);
	// }
	//
	// /** @pdGenerated default removeAll */
	// public void removeAllRacuni() {
	// if (racuni != null)
	// racuni.clear();
	// }

}