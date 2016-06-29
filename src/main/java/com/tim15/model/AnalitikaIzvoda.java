/***********************************************************************
 * Module:  AnalitikaIzvoda.java
 * Author:  Shuky
 * Purpose: Defines the Class AnalitikaIzvoda
 ***********************************************************************/

package com.tim15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnalitikaIzvoda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
   private long brojStavke;
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
   @JoinColumn(name="dnevno_stanje_racuna_id")
   private DnevnoStanjeRacuna dnevnoStanjeRacuna;

}