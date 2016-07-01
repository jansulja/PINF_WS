/***********************************************************************
 * Module:  DnevnoStanjeRacuna.java
 * Author:  Shuky
 * Purpose: Defines the Class DnevnoStanjeRacuna
 ***********************************************************************/

package com.tim15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity
public class DnevnoStanjeRacuna {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dnevno_stanje_racuna_id", unique = true)
   private long brojIzvoda;
   private java.util.Date datumPrometa;
   private double prethodnoStanje = 0;
   private double prometUKorist = 0;
   private double prometNaTeret = 0;
   private double novoStanje = 0;

   @ManyToOne
   @JoinColumn(name="racuni_id")
   @JsonBackReference
   private Racuni racuni;

   @OneToMany(mappedBy="dnevnoStanjeRacuna")
   private java.util.Collection<AnalitikaIzvoda> analitikaIzvoda;


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