/***********************************************************************
 * Module:  AnalitikaIzvoda.java
 * Author:  Shuky
 * Purpose: Defines the Class AnalitikaIzvoda
 ***********************************************************************/

package com.tim15.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="analitikaIzvodaId",scope=AnalitikaIzvoda.class)
public class AnalitikaIzvoda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analitika_izvoda_id", unique = true)
	private int analitikaIzvodaId;
	private java.lang.String duznikNalogodavac;
	private java.lang.String svrhaPlacanja;
	private java.lang.String poverilacPrimalac;
	private java.util.Date datumPrijema;
	private java.util.Date datumValute;
	private java.lang.String racunDuznika;
	private double modelZaduzenja;
	private java.lang.String pozivNaProjZaduzenja;
	private java.lang.String racunPoverioca;
	private double modelOdobrenja;
	private java.lang.String pozivNaBrojOdobrenja;
	private boolean hitno = false;
	private double iznos = 0;
	private double tipGreske = 1;
	private java.lang.String status;

	@ManyToOne
	@JoinColumn(name = "dnevno_stanje_racuna_id")
	@JsonBackReference(value="dnevnoStanjeRacunaAnalitikaIzvoda")
	private DnevnoStanjeRacuna dnevnoStanjeRacuna;

	@ManyToOne
	@JoinColumn(name = "valuta_id")
	@JsonBackReference(value="valutaAnalitikaIzvoda")
	private Valuta valuta;

	@ManyToOne(optional=false)
	@JoinColumn(name = "naseljenomesto_id")
//	@JsonBackReference("naseljenoMestoAnalitikaIzvoda")
	private NaseljenoMesto naseljenoMesto;

	@ManyToOne
	@JoinColumn(name = "vrsteplacanja_id")
	@JsonBackReference(value="vrstePlacanjaAnalitikaIzvoda")
	private VrstePlacanja vrstePlacanja;




	public AnalitikaIzvoda() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AnalitikaIzvoda(int analitikaIzvodaId, String duznikNalogodavac, String svrhaPlacanja, String poverilacPrimalac, Date datumPrijema,
			Date datumValute, String racunDuznika, double modelZaduzenja, String pozivNaProjZaduzenja,
			String racunPoverioca, double modelOdobrenja, String pozivNaBrojOdobrenja, boolean hitno, double iznos,
			double tipGreske, String status, DnevnoStanjeRacuna dnevnoStanjeRacuna, Valuta valuta,
			NaseljenoMesto naseljenoMesto, VrstePlacanja vrstePlacanja) {
		super();
		this.analitikaIzvodaId = analitikaIzvodaId;
		this.duznikNalogodavac = duznikNalogodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.poverilacPrimalac = poverilacPrimalac;
		this.datumPrijema = datumPrijema;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaProjZaduzenja = pozivNaProjZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.hitno = hitno;
		this.iznos = iznos;
		this.tipGreske = tipGreske;
		this.status = status;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
		this.valuta = valuta;
		this.naseljenoMesto = naseljenoMesto;
		this.vrstePlacanja = vrstePlacanja;
	}



	public int getAnalitikaIzvodaId() {
		return analitikaIzvodaId;
	}

	public void setAnalitikaIzvodaId(int analitikaIzvodaId) {
		this.analitikaIzvodaId = analitikaIzvodaId;
	}

	public java.lang.String getDuznikNalogodavac() {
		return duznikNalogodavac;
	}

	public void setDuznikNalogodavac(java.lang.String duznikNalogodavac) {
		this.duznikNalogodavac = duznikNalogodavac;
	}

	public java.lang.String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(java.lang.String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public java.lang.String getPoverilacPrimalac() {
		return poverilacPrimalac;
	}

	public void setPoverilacPrimalac(java.lang.String poverilacPrimalac) {
		this.poverilacPrimalac = poverilacPrimalac;
	}

	public java.util.Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(java.util.Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public java.util.Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(java.util.Date datumValute) {
		this.datumValute = datumValute;
	}

	public java.lang.String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(java.lang.String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public double getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(double modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public java.lang.String getPozivNaProjZaduzenja() {
		return pozivNaProjZaduzenja;
	}

	public void setPozivNaProjZaduzenja(java.lang.String pozivNaProjZaduzenja) {
		this.pozivNaProjZaduzenja = pozivNaProjZaduzenja;
	}

	public java.lang.String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(java.lang.String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public double getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(double modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public java.lang.String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(java.lang.String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public double getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(double tipGreske) {
		this.tipGreske = tipGreske;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public VrstePlacanja getVrstePlacanja() {
		return vrstePlacanja;
	}

	public void setVrstePlacanja(VrstePlacanja vrstePlacanja) {
		this.vrstePlacanja = vrstePlacanja;
	}




}