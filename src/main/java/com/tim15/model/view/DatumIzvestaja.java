package com.tim15.model.view;

import java.util.Date;

public class DatumIzvestaja {

	private int klijentId;
	private Date datumOd;
	private Date datumDo;

	public DatumIzvestaja(int klijentId, Date datumOd, Date datumDo) {
		super();
		this.klijentId = klijentId;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}
	public DatumIzvestaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getKlijentId() {
		return klijentId;
	}
	public void setKlijentId(int klijentId) {
		this.klijentId = klijentId;
	}
	public Date getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}
	public Date getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}



}
