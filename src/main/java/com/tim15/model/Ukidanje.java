/***********************************************************************
 * Module:  Ukidanje.java
 * Author:  Shuky
 * Purpose: Defines the Class Ukidanje
 ***********************************************************************/

package com.tim15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity
public class Ukidanje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ukidanje_id", unique = true)
   private int idUkidanja;
   private java.util.Date datumUkidanja;
   private java.lang.String sredstvaSePrenoseNaRacun;

   @ManyToOne
   @JoinColumn(name = "racuni_id")
   @JsonBackReference
   private Racuni racuni;

}