/***********************************************************************
 * Module:  KursnaLista.java
 * Author:  Shuky
 * Purpose: Defines the Class KursnaLista
 ***********************************************************************/

package com.tim15.model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KursnaLista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kursnalista_id", unique = true)
	private int kursnaListaId;
	private Date datum;
	private int brojKursneListe;
	private Date primenjujeSeOd;

	@ManyToOne(optional=false)
	@JoinColumn(name = "banka_id")
	private Banka banka;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "kursnaLista", orphanRemoval=true)
	@JsonIgnore
	private Set<KursUValuti> kursUValuti;

	public KursnaLista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KursnaLista(Date datum, int brojKursneListe, Date primenjujeSeOd, Banka banka,
			Set<KursUValuti> kursUValuti) {
		super();
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
		this.kursUValuti = kursUValuti;
	}

	public int getKursnaListaId() {
		return kursnaListaId;
	}

	public void setKursnaListaId(int kursnaListaId) {
		this.kursnaListaId = kursnaListaId;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public double getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(int brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}




	@JsonIgnore
	public Set<KursUValuti> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(Set<KursUValuti> kursUValuti) {
		if(this.kursUValuti!=null){
			this.kursUValuti.clear();
		}else{
			this.kursUValuti = new HashSet<KursUValuti>();
		}

	    if (kursUValuti != null) {
	        this.kursUValuti.addAll(kursUValuti);
	    }
	}

	/** @pdGenerated default iterator getter */
	@JsonIgnore
	public java.util.Iterator getIteratorKursUValuti() {
		if (kursUValuti == null)
			kursUValuti = new java.util.HashSet<KursUValuti>();
		return kursUValuti.iterator();
	}

	public void addKursUValuti(KursUValuti newKursUValuti) {
		if (newKursUValuti == null)
			return;
		if (this.kursUValuti == null)
			this.kursUValuti = new java.util.HashSet<KursUValuti>();
		if (!this.kursUValuti.contains(newKursUValuti))
			this.kursUValuti.add(newKursUValuti);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldKursUValuti
	 */
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