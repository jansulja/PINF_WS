package com.tim15.model.view;

public class NalogZaUplatu {

	private String uplatilac;
	private String svrhaUplate;
	private String primalac;
	private String mestoIDatum;
	private double iznos;
	private String valuta;
	private String racunPrimaoca;
	private String model;
	private String pozivNaBroj;

	public NalogZaUplatu() {
		super();
	}

	public NalogZaUplatu(String uplatilac, String svrhaUplate, String primalac, String mestoIDatum, double iznos,
			String valuta, String racunPrimaoca, String model, String pozivNaBroj) {
		super();
		this.uplatilac = uplatilac;
		this.svrhaUplate = svrhaUplate;
		this.primalac = primalac;
		this.mestoIDatum = mestoIDatum;
		this.iznos = iznos;
		this.valuta = valuta;
		this.racunPrimaoca = racunPrimaoca;
		this.model = model;
		this.pozivNaBroj = pozivNaBroj;
	}

	public String getUplatilac() {
		return uplatilac;
	}

	public void setUplatilac(String uplatilac) {
		this.uplatilac = uplatilac;
	}

	public String getSvrhaUplate() {
		return svrhaUplate;
	}

	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public String getMestoIDatum() {
		return mestoIDatum;
	}

	public void setMestoIDatum(String mestoIDatum) {
		this.mestoIDatum = mestoIDatum;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public String getRacunPrimaoca() {
		return racunPrimaoca;
	}

	public void setRacunPrimaoca(String racunPrimaoca) {
		this.racunPrimaoca = racunPrimaoca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

}
