package com.tim15.sessionbeans;

import com.tim15.model.NaseljenoMesto;

public interface NaseljenoMestoDaoLocal extends GenericDao<NaseljenoMesto, Integer> {

	public NaseljenoMesto findByNaziv(String naziv);

}
