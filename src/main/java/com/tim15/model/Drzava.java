/***********************************************************************
 * Module:  Drzava.java
 * Author:  Shuky
 * Purpose: Defines the Class Drzava
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
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Drzava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drzava_id", unique = true)
   private double sifraDrzave;
   private java.lang.String nazivDrzave;

   public double getSifraDrzave() {
	return sifraDrzave;
}

   public void setSifraDrzave(double sifraDrzave) {
	this.sifraDrzave = sifraDrzave;
}

	public java.lang.String getNazivDrzave() {
	return nazivDrzave;
}

	public void setNazivDrzave(java.lang.String nazivDrzave) {
	this.nazivDrzave = nazivDrzave;
}

/** @pdRoleInfo migr=no name=Valuta assc=drzavnaValuta coll=java.util.Collection impl=java.util.HashSet mult=0..* */

	@OneToMany(mappedBy = "drzava")
	private java.util.Collection<Valuta> valuta;
   /** @pdRoleInfo migr=no name=NaseljenoMesto assc=mestaUDrzavi coll=java.util.Collection impl=java.util.HashSet mult=0..* */
	@Transient
	private java.util.Collection<NaseljenoMesto> naseljenoMesto;


   /** @pdGenerated default getter */
   public java.util.Collection<Valuta> getValuta() {
      if (valuta == null)
         valuta = new java.util.HashSet<Valuta>();
      return valuta;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorValuta() {
      if (valuta == null)
         valuta = new java.util.HashSet<Valuta>();
      return valuta.iterator();
   }

   /** @pdGenerated default setter
     * @param newValuta */
   public void setValuta(java.util.Collection<Valuta> newValuta) {
      removeAllValuta();
      for (java.util.Iterator iter = newValuta.iterator(); iter.hasNext();)
         addValuta((Valuta)iter.next());
   }

   /** @pdGenerated default add
     * @param newValuta */
   public void addValuta(Valuta newValuta) {
      if (newValuta == null)
         return;
      if (this.valuta == null)
         this.valuta = new java.util.HashSet<Valuta>();
      if (!this.valuta.contains(newValuta))
         this.valuta.add(newValuta);
   }

   /** @pdGenerated default remove
     * @param oldValuta */
   public void removeValuta(Valuta oldValuta) {
      if (oldValuta == null)
         return;
      if (this.valuta != null)
         if (this.valuta.contains(oldValuta))
            this.valuta.remove(oldValuta);
   }

   /** @pdGenerated default removeAll */
   public void removeAllValuta() {
      if (valuta != null)
         valuta.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<NaseljenoMesto> getNaseljenoMesto() {
      if (naseljenoMesto == null)
         naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
      return naseljenoMesto;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNaseljenoMesto() {
      if (naseljenoMesto == null)
         naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
      return naseljenoMesto.iterator();
   }

   /** @pdGenerated default setter
     * @param newNaseljenoMesto */
   public void setNaseljenoMesto(java.util.Collection<NaseljenoMesto> newNaseljenoMesto) {
      removeAllNaseljenoMesto();
      for (java.util.Iterator iter = newNaseljenoMesto.iterator(); iter.hasNext();)
         addNaseljenoMesto((NaseljenoMesto)iter.next());
   }

   /** @pdGenerated default add
     * @param newNaseljenoMesto */
   public void addNaseljenoMesto(NaseljenoMesto newNaseljenoMesto) {
      if (newNaseljenoMesto == null)
         return;
      if (this.naseljenoMesto == null)
         this.naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
      if (!this.naseljenoMesto.contains(newNaseljenoMesto))
         this.naseljenoMesto.add(newNaseljenoMesto);
   }

   /** @pdGenerated default remove
     * @param oldNaseljenoMesto */
   public void removeNaseljenoMesto(NaseljenoMesto oldNaseljenoMesto) {
      if (oldNaseljenoMesto == null)
         return;
      if (this.naseljenoMesto != null)
         if (this.naseljenoMesto.contains(oldNaseljenoMesto))
            this.naseljenoMesto.remove(oldNaseljenoMesto);
   }

   /** @pdGenerated default removeAll */
   public void removeAllNaseljenoMesto() {
      if (naseljenoMesto != null)
         naseljenoMesto.clear();
   }

}