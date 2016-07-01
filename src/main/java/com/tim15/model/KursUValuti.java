/***********************************************************************
 * Module:  KursUValuti.java
 * Author:  Shuky
 * Purpose: Defines the Class KursUValuti
 ***********************************************************************/

package com.tim15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class KursUValuti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kurs_u_valuti_id", unique = true)
	private int kursUValutiId;
	private double kupovni = 0;
	private double srednji = 0;

	@ManyToOne
	@JoinColumn(name = "valuta_id")
	@JsonBackReference
	private Valuta valuta;

	@ManyToOne
	@JoinColumn(name = "kursnalista_id")
	@JsonBackReference
	private KursnaLista kursnaLista;

	public KursUValuti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursUValuti(double kupovni, double srednji, Valuta valuta, KursnaLista kursnaLista, double prodajni) {
		super();
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.valuta = valuta;
		this.kursnaLista = kursnaLista;
		this.prodajni = prodajni;
	}

	public int getKursUValutiId() {
		return kursUValutiId;
	}

	public void setKursUValutiId(int kursUValutiId) {
		this.kursUValutiId = kursUValutiId;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	private double prodajni = 0;

}