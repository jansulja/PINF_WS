package com.tim15.sessionbeans;

import com.tim15.model.Racuni;
import com.tim15.model.Ukidanje;

public interface RacuniDaoLocal extends GenericDao<Racuni, Integer> {

	public Racuni findByNumber(String number);
	public void addFunds(String accountNum, double funds);
	public void ukiniRacun(Ukidanje ukidanje);

}
