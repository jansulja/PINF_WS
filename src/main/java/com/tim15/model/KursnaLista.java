/***********************************************************************
 * Module:  KursnaLista.java
 * Author:  Shuky
 * Purpose: Defines the Class KursnaLista
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
@Entity
public class KursnaLista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kursnalista_id", unique = true)
   private int idKursneListe;
   private java.util.Date datum;
   private double brojKursneListe;
   private java.util.Date primenjujeSeOd;

   @ManyToOne
   @JoinColumn(name="banka_id")
   @JsonBackReference
   private Banka banka ;

   /** @pdRoleInfo migr=no name=KursUValuti assc=valuteUListi coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<KursUValuti> kursUValuti;


   /** @pdGenerated default getter */
   public java.util.Collection<KursUValuti> getKursUValuti() {
      if (kursUValuti == null)
         kursUValuti = new java.util.HashSet<KursUValuti>();
      return kursUValuti;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKursUValuti() {
      if (kursUValuti == null)
         kursUValuti = new java.util.HashSet<KursUValuti>();
      return kursUValuti.iterator();
   }

   /** @pdGenerated default setter
     * @param newKursUValuti */
   public void setKursUValuti(java.util.Collection<KursUValuti> newKursUValuti) {
      removeAllKursUValuti();
      for (java.util.Iterator iter = newKursUValuti.iterator(); iter.hasNext();)
         addKursUValuti((KursUValuti)iter.next());
   }

   /** @pdGenerated default add
     * @param newKursUValuti */
   public void addKursUValuti(KursUValuti newKursUValuti) {
      if (newKursUValuti == null)
         return;
      if (this.kursUValuti == null)
         this.kursUValuti = new java.util.HashSet<KursUValuti>();
      if (!this.kursUValuti.contains(newKursUValuti))
         this.kursUValuti.add(newKursUValuti);
   }

   /** @pdGenerated default remove
     * @param oldKursUValuti */
   public void removeKursUValuti(KursUValuti oldKursUValuti) {
      if (oldKursUValuti == null)
         return;
      if (this.kursUValuti != null)
         if (this.kursUValuti.contains(oldKursUValuti))
            this.kursUValuti.remove(oldKursUValuti);
   }

   /** @pdGenerated default removeAll */
   public void removeAllKursUValuti() {
      if (kursUValuti != null)
         kursUValuti.clear();
   }

}