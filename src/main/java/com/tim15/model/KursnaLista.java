/***********************************************************************
 * Module:  KursnaLista.java
 * Author:  Shuky
 * Purpose: Defines the Class KursnaLista
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

public class KursnaLista {
   public int idKursneListe;
   public java.util.Date datum;
   public double brojKursneListe;
   public java.util.Date primenjujeSeOd;
   
   /** @pdRoleInfo migr=no name=KursUValuti assc=valuteUListi coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<KursUValuti> kursUValuti;
   
   
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