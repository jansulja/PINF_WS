package com.tim15.model;

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
public class Rtgs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rtgs_id", unique = true)
	private int rtgsId;

	private java.lang.String swiftBankeDuznika;

	private java.lang.String racunBankeDuznika;

	private java.lang.String swiftBankePoverioca;

	private java.lang.String racunBankePoverioca;

	@ManyToOne(optional = false)
	@JoinColumn(name = "analitika_izvoda_id")
	private AnalitikaIzvoda analitikaIzvoda;





	public Rtgs(int rtgsId, String swiftBankeDuznika, String racunBankeDuznika, String swiftBankePoverioca,
			String racunBankePoverioca, AnalitikaIzvoda analitikaIzvoda) {
		super();
		this.rtgsId = rtgsId;
		this.swiftBankeDuznika = swiftBankeDuznika;
		this.racunBankeDuznika = racunBankeDuznika;
		this.swiftBankePoverioca = swiftBankePoverioca;
		this.racunBankePoverioca = racunBankePoverioca;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public Rtgs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRtgsId() {
		return rtgsId;
	}

	public void setRtgsId(int rtgsId) {
		this.rtgsId = rtgsId;
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

	public AnalitikaIzvoda getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}

	public void setAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}



}
