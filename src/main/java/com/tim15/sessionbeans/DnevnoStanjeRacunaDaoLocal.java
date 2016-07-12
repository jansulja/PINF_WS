package com.tim15.sessionbeans;

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.Banka;
import com.tim15.model.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaDaoLocal extends GenericDao<DnevnoStanjeRacuna, Integer> {

	public DnevnoStanjeRacuna getPoslednjeStanje(String brojRacuna);

}
