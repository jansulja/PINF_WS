/***********************************************************************
 * Module:  FizickoLice.java
 * Author:  Shuky
 * Purpose: Defines the Class FizickoLice
 ***********************************************************************/

package com.tim15.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name="klijent_id")
public class FizickoLice extends Klijent {

   private java.lang.String punoIme;
   private java.util.Date datumRodjenja;
   private java.lang.String pol;
   private double registarskiBroj;
   private double jmbg;
public FizickoLice(String telefon, String email, String adresa, String password, String punoIme, Date datumRodjenja,
		String pol, double registarskiBroj, double jmbg) {
	super(telefon, email, adresa, password);
	this.punoIme = punoIme;
	this.datumRodjenja = datumRodjenja;
	this.pol = pol;
	this.registarskiBroj = registarskiBroj;
	this.jmbg = jmbg;
}
public FizickoLice() {
	super();
	// TODO Auto-generated constructor stub
}
public FizickoLice(String telefon, String email, String adresa, String password) {
	super(telefon, email, adresa, password);
	// TODO Auto-generated constructor stub
}
public java.lang.String getPunoIme() {
	return punoIme;
}
public void setPunoIme(java.lang.String punoIme) {
	this.punoIme = punoIme;
}
public java.util.Date getDatumRodjenja() {
	return datumRodjenja;
}
public void setDatumRodjenja(java.util.Date datumRodjenja) {
	this.datumRodjenja = datumRodjenja;
}
public java.lang.String getPol() {
	return pol;
}
public void setPol(java.lang.String pol) {
	this.pol = pol;
}
public double getRegistarskiBroj() {
	return registarskiBroj;
}
public void setRegistarskiBroj(double registarskiBroj) {
	this.registarskiBroj = registarskiBroj;
}
public double getJmbg() {
	return jmbg;
}
public void setJmbg(double jmbg) {
	this.jmbg = jmbg;
}
@Override
public String toString() {
	return "FizickoLice [punoIme=" + punoIme + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol
			+ ", registarskiBroj=" + registarskiBroj + ", jmbg=" + jmbg + ", toString()=" + super.toString() + "]";
}




}