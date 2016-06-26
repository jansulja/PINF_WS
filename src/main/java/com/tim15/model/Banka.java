/***********************************************************************
 * Module:  Banka.java
 * Author:  Shuky
 * Purpose: Defines the Class Banka
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

public class Banka {
   public int idBanke;
   public java.lang.String sifraBanke;
   public java.lang.String pib;
   public java.lang.String naziv;
   public java.lang.String adresa;
   public java.lang.String eMail;
   public java.lang.String web;
   public java.lang.String telefon;
   public java.lang.String fax;
   public boolean banka;

   /** @pdRoleInfo migr=no name=Racuni assc=poslovnaBanka coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Racuni> racuni;
   /** @pdRoleInfo migr=no name=KursnaLista assc=kursPoslovneBanke coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<KursnaLista> kursnaLista;


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
   public java.util.Collection<KursnaLista> getKursnaLista() {
      if (kursnaLista == null)
         kursnaLista = new java.util.HashSet<KursnaLista>();
      return kursnaLista;
   }

   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKursnaLista() {
      if (kursnaLista == null)
         kursnaLista = new java.util.HashSet<KursnaLista>();
      return kursnaLista.iterator();
   }

   /** @pdGenerated default setter
     * @param newKursnaLista */
   public void setKursnaLista(java.util.Collection<KursnaLista> newKursnaLista) {
      removeAllKursnaLista();
      for (java.util.Iterator iter = newKursnaLista.iterator(); iter.hasNext();)
         addKursnaLista((KursnaLista)iter.next());
   }

   /** @pdGenerated default add
     * @param newKursnaLista */
   public void addKursnaLista(KursnaLista newKursnaLista) {
      if (newKursnaLista == null)
         return;
      if (this.kursnaLista == null)
         this.kursnaLista = new java.util.HashSet<KursnaLista>();
      if (!this.kursnaLista.contains(newKursnaLista))
         this.kursnaLista.add(newKursnaLista);
   }

   /** @pdGenerated default remove
     * @param oldKursnaLista */
   public void removeKursnaLista(KursnaLista oldKursnaLista) {
      if (oldKursnaLista == null)
         return;
      if (this.kursnaLista != null)
         if (this.kursnaLista.contains(oldKursnaLista))
            this.kursnaLista.remove(oldKursnaLista);
   }

   /** @pdGenerated default removeAll */
   public void removeAllKursnaLista() {
      if (kursnaLista != null)
         kursnaLista.clear();
   }

}