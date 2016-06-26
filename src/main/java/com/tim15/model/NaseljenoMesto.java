/***********************************************************************
 * Module:  NaseljenoMesto.java
 * Author:  Shuky
 * Purpose: Defines the Class NaseljenoMesto
 ***********************************************************************/

package com.tim15.model;

import java.util.*;

public class NaseljenoMesto {
   public int sifraMesta;
   public java.lang.String naziv;
   public java.lang.String pTToznaka;
   
   /** @pdRoleInfo migr=no name=AnalitikaIzvoda assc=mestoPrijema coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<AnalitikaIzvoda> analitikaIzvoda;
   
   
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