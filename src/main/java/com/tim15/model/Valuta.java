/***********************************************************************
 * Module:  Valuta.java
 * Author:  Shuky
 * Purpose: Defines the Class Valuta
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
public class Valuta {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "valuta_id", unique = true)
    private int idValute;
	private java.lang.String zvanicnaSifra;
	private java.lang.String naziv;
	private boolean domicilna = false;
	@ManyToOne
	@JoinColumn(name="drzava_id")
	private Drzava drzava ;
   /** @pdRoleInfo migr=no name=KursUValuti assc=osnovnaValuta coll=java.util.Collection impl=java.util.HashSet mult=0..* */
	@Transient
	private java.util.Collection<KursUValuti> kursUValutiOsnovna;
   /** @pdRoleInfo migr=no name=KursUValuti assc=premaValuti coll=java.util.Collection impl=java.util.HashSet mult=0..* */
	@Transient
	private java.util.Collection<KursUValuti> kursUValutiPrema;
   /** @pdRoleInfo migr=no name=Racuni assc=valutaRacuna coll=java.util.Collection impl=java.util.HashSet mult=0..* */
	@Transient
	private java.util.Collection<Racuni> racuni;
   /** @pdRoleInfo migr=no name=AnalitikaIzvoda assc=valutaPlacanja coll=java.util.Collection impl=java.util.HashSet mult=0..* */
	@Transient
	private java.util.Collection<AnalitikaIzvoda> analitikaIzvoda;



   /** @pdGenerated default getter */
   public java.util.Collection<Racuni> getRacuni() {
      if (racuni == null)
         racuni = new java.util.HashSet<Racuni>();
      return racuni;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRacuni() {
      if (racuni == null)
         racuni = new java.util.HashSet<Racuni>();
      return racuni.iterator();
   }

   /** @pdGenerated default setter
     * @param newRacuni */
   public void setRacuni(java.util.Collection<Racuni> newRacuni) {
      removeAllRacuni();
      for (java.util.Iterator iter = newRacuni.iterator(); iter.hasNext();)
         addRacuni((Racuni)iter.next());
   }

   /** @pdGenerated default add
     * @param newRacuni */
   public void addRacuni(Racuni newRacuni) {
      if (newRacuni == null)
         return;
      if (this.racuni == null)
         this.racuni = new java.util.HashSet<Racuni>();
      if (!this.racuni.contains(newRacuni))
         this.racuni.add(newRacuni);
   }

   /** @pdGenerated default remove
     * @param oldRacuni */
   public void removeRacuni(Racuni oldRacuni) {
      if (oldRacuni == null)
         return;
      if (this.racuni != null)
         if (this.racuni.contains(oldRacuni))
            this.racuni.remove(oldRacuni);
   }

   /** @pdGenerated default removeAll */
   public void removeAllRacuni() {
      if (racuni != null)
         racuni.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<AnalitikaIzvoda> getAnalitikaIzvoda() {
      if (analitikaIzvoda == null)
         analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
      return analitikaIzvoda;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAnalitikaIzvoda() {
      if (analitikaIzvoda == null)
         analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
      return analitikaIzvoda.iterator();
   }

   /** @pdGenerated default setter
     * @param newAnalitikaIzvoda */
   public void setAnalitikaIzvoda(java.util.Collection<AnalitikaIzvoda> newAnalitikaIzvoda) {
      removeAllAnalitikaIzvoda();
      for (java.util.Iterator iter = newAnalitikaIzvoda.iterator(); iter.hasNext();)
         addAnalitikaIzvoda((AnalitikaIzvoda)iter.next());
   }

   /** @pdGenerated default add
     * @param newAnalitikaIzvoda */
   public void addAnalitikaIzvoda(AnalitikaIzvoda newAnalitikaIzvoda) {
      if (newAnalitikaIzvoda == null)
         return;
      if (this.analitikaIzvoda == null)
         this.analitikaIzvoda = new java.util.HashSet<AnalitikaIzvoda>();
      if (!this.analitikaIzvoda.contains(newAnalitikaIzvoda))
         this.analitikaIzvoda.add(newAnalitikaIzvoda);
   }

   /** @pdGenerated default remove
     * @param oldAnalitikaIzvoda */
   public void removeAnalitikaIzvoda(AnalitikaIzvoda oldAnalitikaIzvoda) {
      if (oldAnalitikaIzvoda == null)
         return;
      if (this.analitikaIzvoda != null)
         if (this.analitikaIzvoda.contains(oldAnalitikaIzvoda))
            this.analitikaIzvoda.remove(oldAnalitikaIzvoda);
   }

   /** @pdGenerated default removeAll */
   public void removeAllAnalitikaIzvoda() {
      if (analitikaIzvoda != null)
         analitikaIzvoda.clear();
   }

}