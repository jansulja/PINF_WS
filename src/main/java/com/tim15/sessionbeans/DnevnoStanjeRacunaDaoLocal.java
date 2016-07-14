package com.tim15.sessionbeans;

import java.util.List;

import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Klijent;
import com.tim15.model.view.DatumIzvestaja;

public interface DnevnoStanjeRacunaDaoLocal extends GenericDao<DnevnoStanjeRacuna, Integer> {

	public DnevnoStanjeRacuna getPoslednjeStanje(String brojRacuna);
	public List<DnevnoStanjeRacuna> getStanjeZaPeriod(DatumIzvestaja period);

}
