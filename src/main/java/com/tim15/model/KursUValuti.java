/***********************************************************************
 * Module:  KursUValuti.java
 * Author:  Shuky
 * Purpose: Defines the Class KursUValuti
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity
public class KursUValuti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kursuvaluti_id", unique = true)
   private double redniBroj;
   private double kupovni = 0;
   private double srednji = 0;

   @ManyToOne
   @JoinColumn(name="valuta_id")
   @JsonBackReference
   private Valuta valuta;

   @ManyToOne
   @JoinColumn(name="kursnalista_id")
   @JsonBackReference
   private KursnaLista kursnaLista;


   public double getRedniBroj() {
	return redniBroj;
}
public void setRedniBroj(double redniBroj) {
	this.redniBroj = redniBroj;
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