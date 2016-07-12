package com.tim15.sessionbeans;

import com.tim15.model.Valuta;
import com.tim15.model.VrstePlacanja;

public interface VrstePlacanjaDaoLocal extends GenericDao<VrstePlacanja, Integer> {

	public VrstePlacanja findByOznaka(int oznaka);

}
