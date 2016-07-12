package com.tim15.sessionbeans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.tim15.model.NaseljenoMesto;
import com.tim15.model.Valuta;


@Stateless
@Local(NaseljenoMestoDaoLocal.class)
public class NaseljenoMestoDaoBean extends GenericDaoBean<NaseljenoMesto, Integer> implements NaseljenoMestoDaoLocal{

	@Override
	public NaseljenoMesto findByNaziv(String naziv) {

		String query = "SELECT DISTINCT nm FROM NaseljenoMesto nm WHERE nm.naziv = '" +
				naziv + "'";

				Query q = em.createQuery(query);
				List<NaseljenoMesto> result = q.getResultList();

				NaseljenoMesto naseljenoMesto = null;

				if(!result.isEmpty()){
					naseljenoMesto = result.get(0);
				}

				return naseljenoMesto;
	}

}
