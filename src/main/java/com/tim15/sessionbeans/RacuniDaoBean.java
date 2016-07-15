package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.tim15.model.Racuni;
import com.tim15.model.Ukidanje;


@Stateless
@Local(RacuniDaoLocal.class)
public class RacuniDaoBean extends GenericDaoBean<Racuni, Integer> implements RacuniDaoLocal {

	@Override
	public Racuni findByNumber(String number) {
		String query = "select distinct u from " + "Racuni u where u.brojRacuna =  '" + number +"'";

		return this.findBy(query).get(0);


	}

	@Override
	public void addFunds(String accountNum, double funds) {
		String query = "select distinct u from " + "Racuni u where u.brojRacuna =  '" + accountNum +"'";

		Racuni racun = this.findBy(query).get(0);
		racun.addFunds(funds);
		try {
			this.merge(racun);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void ukiniRacun(Ukidanje ukidanje) {

		Query query = em.createNativeQuery("{call ukidanje(?,?)}")
                .setParameter(1, ukidanje.getRacuni().getRacuniId())
                .setParameter(2, ukidanje.getSredstvaSePrenoseNaRacun());
		query.executeUpdate();
	}

}
