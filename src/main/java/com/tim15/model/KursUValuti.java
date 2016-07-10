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
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KursUValuti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kurs_u_valuti_id", unique = true)
	private int kursUValutiId;
	private double kupovni = 0;
	private double srednji = 0;
	private double prodajni = 0;
	@ManyToOne(optional=false)
	@PrimaryKeyJoinColumn(name="valuta_osnovna_id", referencedColumnName="valuta_id")
	private Valuta valutaOsnovna;

	@ManyToOne(optional=false)
	@PrimaryKeyJoinColumn(name="valuta_prema_id", referencedColumnName="valuta_id")
	private Valuta valutaPrema;

	@ManyToOne(optional=false)
	@JoinColumn(name = "kursnalista_id")
	private KursnaLista kursnaLista;

	public KursUValuti() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KursUValuti(int kursUValutiId, double kupovni, double srednji, double prodajni, Valuta valutaOsnovna,
			Valuta valutaPrema, KursnaLista kursnaLista) {
		super();
		this.kursUValutiId = kursUValutiId;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.valutaOsnovna = valutaOsnovna;
		this.valutaPrema = valutaPrema;
		this.kursnaLista = kursnaLista;
	}


	public Valuta getValutaOsnovna() {
		return valutaOsnovna;
	}



	public void setValutaOsnovna(Valuta valutaOsnovna) {
		this.valutaOsnovna = valutaOsnovna;
	}



	public Valuta getValutaPrema() {
		return valutaPrema;
	}



	public void setValutaPrema(Valuta valutaPrema) {
		this.valutaPrema = valutaPrema;
	}



	public int getKursUValutiId() {
		return kursUValutiId;
	}

	public void setKursUValutiId(int kursUValutiId) {
		this.kursUValutiId = kursUValutiId;
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



}