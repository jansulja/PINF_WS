package com.tim15.sessionbeans;

import com.tim15.model.Valuta;

public interface ValutaDaoLocal extends GenericDao<Valuta, Integer> {

	public Valuta findByZvanicnaSifra(String zvanicnaSifra);

}
