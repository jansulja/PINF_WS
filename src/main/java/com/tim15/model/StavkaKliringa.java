package com.tim15.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StavkaKliringa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stavka_kliringa_id", unique = true)
	private int stavkaKliringaId;

	private java.lang.String swiftBankeDuznika;

	private java.lang.String racunBankeDuznika;

	private java.lang.String swiftBankePoverioca;

	private java.lang.String racunBankePoverioca;

	private double ukupanIznos;

	private java.lang.String sifraValute;

	private java.sql.Date datumValute;

	@ManyToOne(optional = false)
	@JoinColumn(name = "analitika_izvoda_id")
	private AnalitikaIzvoda analitikaIzvoda;


	@ManyToOne(optional=false)
	@JoinColumn(name = "kliring_id")
	private Kliring kliring;



	public StavkaKliringa(int stavkaKliringaId, String swiftBankeDuznika, String racunBankeDuznika,
			String swiftBankePoverioca, String racunBankePoverioca, double ukupanIznos, String sifraValute,
			java.sql.Date datumValute, AnalitikaIzvoda analitikaIzvoda, Kliring kliring) {
		super();
		this.stavkaKliringaId = stavkaKliringaId;
		this.swiftBankeDuznika = swiftBankeDuznika;
		this.racunBankeDuznika = racunBankeDuznika;
		this.swiftBankePoverioca = swiftBankePoverioca;
		this.racunBankePoverioca = racunBankePoverioca;
		this.ukupanIznos = ukupanIznos;
		this.sifraValute = sifraValute;
		this.datumValute = datumValute;
		this.analitikaIzvoda = analitikaIzvoda;
		this.kliring = kliring;
	}

	public StavkaKliringa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStavkaKliringaId() {
		return stavkaKliringaId;
	}

	public void setStavkaKliringaId(int stavkaKliringaId) {
		this.stavkaKliringaId = stavkaKliringaId;
	}

	public java.lang.String getSwiftBankeDuznika() {
		return swiftBankeDuznika;
	}

	public void setSwiftBankeDuznika(java.lang.String swiftBankeDuznika) {
		this.swiftBankeDuznika = swiftBankeDuznika;
	}

	public java.lang.String getRacunBankeDuznika() {
		return racunBankeDuznika;
	}

	public void setRacunBankeDuznika(java.lang.String racunBankeDuznika) {
		this.racunBankeDuznika = racunBankeDuznika;
	}

	public java.lang.String getSwiftBankePoverioca() {
		return swiftBankePoverioca;
	}

	public void setSwiftBankePoverioca(java.lang.String swiftBankePoverioca) {
		this.swiftBankePoverioca = swiftBankePoverioca;
	}

	public java.lang.String getRacunBankePoverioca() {
		return racunBankePoverioca;
	}

	public void setRacunBankePoverioca(java.lang.String racunBankePoverioca) {
		this.racunBankePoverioca = racunBankePoverioca;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public java.lang.String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(java.lang.String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public java.sql.Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(java.sql.Date datumValute) {
		this.datumValute = datumValute;
	}

	public AnalitikaIzvoda getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}

	public void setAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public Kliring getKliring() {
		return kliring;
	}

	public void setKliring(Kliring kliring) {
		this.kliring = kliring;
	}


}