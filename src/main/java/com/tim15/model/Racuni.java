/***********************************************************************
 * Module:  Racuni.java
 * Author:  Shuky
 * Purpose: Defines the Class Racuni
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
import javax.persistence.Table;
@Entity
@Table(name="racuni")
public class Racuni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "racuni_id", unique = true)
   private long idRacuna;
   private java.lang.String brojRacuna;
   private java.util.Date datumOtvaranja;
   private boolean vazeci = false;

   @ManyToOne
   @JoinColumn(name="klijent_id")
   private Klijent klijent;

   @OneToMany(mappedBy="racuni")
   private java.util.Collection<DnevnoStanjeRacuna> dnevnoStanjeRacuna;

   @OneToMany(mappedBy="racuni")
   private java.util.Collection<Ukidanje> ukidanje;


   /** @pdGenerated default getter */
   public java.util.Collection<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
      if (dnevnoStanjeRacuna == null)
         dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
      return dnevnoStanjeRacuna;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDnevnoStanjeRacuna() {
      if (dnevnoStanjeRacuna == null)
         dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
      return dnevnoStanjeRacuna.iterator();
   }

   /** @pdGenerated default setter
     * @param newDnevnoStanjeRacuna */
   public void setDnevnoStanjeRacuna(java.util.Collection<DnevnoStanjeRacuna> newDnevnoStanjeRacuna) {
      removeAllDnevnoStanjeRacuna();
      for (java.util.Iterator iter = newDnevnoStanjeRacuna.iterator(); iter.hasNext();)
         addDnevnoStanjeRacuna((DnevnoStanjeRacuna)iter.next());
   }

   /** @pdGenerated default add
     * @param newDnevnoStanjeRacuna */
   public void addDnevnoStanjeRacuna(DnevnoStanjeRacuna newDnevnoStanjeRacuna) {
      if (newDnevnoStanjeRacuna == null)
         return;
      if (this.dnevnoStanjeRacuna == null)
         this.dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
      if (!this.dnevnoStanjeRacuna.contains(newDnevnoStanjeRacuna))
         this.dnevnoStanjeRacuna.add(newDnevnoStanjeRacuna);
   }

   /** @pdGenerated default remove
     * @param oldDnevnoStanjeRacuna */
   public void removeDnevnoStanjeRacuna(DnevnoStanjeRacuna oldDnevnoStanjeRacuna) {
      if (oldDnevnoStanjeRacuna == null)
         return;
      if (this.dnevnoStanjeRacuna != null)
         if (this.dnevnoStanjeRacuna.contains(oldDnevnoStanjeRacuna))
            this.dnevnoStanjeRacuna.remove(oldDnevnoStanjeRacuna);
   }

   /** @pdGenerated default removeAll */
   public void removeAllDnevnoStanjeRacuna() {
      if (dnevnoStanjeRacuna != null)
         dnevnoStanjeRacuna.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Ukidanje> getUkidanje() {
      if (ukidanje == null)
         ukidanje = new java.util.HashSet<Ukidanje>();
      return ukidanje;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUkidanje() {
      if (ukidanje == null)
         ukidanje = new java.util.HashSet<Ukidanje>();
      return ukidanje.iterator();
   }

   /** @pdGenerated default setter
     * @param newUkidanje */
   public void setUkidanje(java.util.Collection<Ukidanje> newUkidanje) {
      removeAllUkidanje();
      for (java.util.Iterator iter = newUkidanje.iterator(); iter.hasNext();)
         addUkidanje((Ukidanje)iter.next());
   }

   /** @pdGenerated default add
     * @param newUkidanje */
   public void addUkidanje(Ukidanje newUkidanje) {
      if (newUkidanje == null)
         return;
      if (this.ukidanje == null)
         this.ukidanje = new java.util.HashSet<Ukidanje>();
      if (!this.ukidanje.contains(newUkidanje))
         this.ukidanje.add(newUkidanje);
   }

   /** @pdGenerated default remove
     * @param oldUkidanje */
   public void removeUkidanje(Ukidanje oldUkidanje) {
      if (oldUkidanje == null)
         return;
      if (this.ukidanje != null)
         if (this.ukidanje.contains(oldUkidanje))
            this.ukidanje.remove(oldUkidanje);
   }

   /** @pdGenerated default removeAll */
   public void removeAllUkidanje() {
      if (ukidanje != null)
         ukidanje.clear();
   }

}