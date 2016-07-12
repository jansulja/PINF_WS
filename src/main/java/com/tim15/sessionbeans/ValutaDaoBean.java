package com.tim15.sessionbeans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Valuta;

@Stateless
@Local(ValutaDaoLocal.class)
public class ValutaDaoBean extends GenericDaoBean<Valuta, Integer> implements ValutaDaoLocal {

	@Override
	public Valuta findByZvanicnaSifra(String zvanicnaSifra) {

		String query = "SELECT DISTINCT v FROM Valuta v WHERE v.zvanicnaSifra = '" +
				zvanicnaSifra + "'";

				Query q = em.createQuery(query);
				List<Valuta> result = q.getResultList();

				Valuta valuta = null;

				if(!result.isEmpty()){
					valuta = result.get(0);
				}

				return valuta;

	}



}
