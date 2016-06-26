/***********************************************************************
 * Module:  Klijent.java
 * Author:  Shuky
 * Purpose: Defines the Class Klijent
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

public class Klijent {
   public int idKlijenta;
   public java.lang.String telefon;
   public java.lang.String email;
   public java.lang.String adresa;
   public java.lang.String password;
   
   /** @pdRoleInfo migr=no name=Racuni assc=vlasnikRacuna coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Racuni> racuni;
   
   
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

}