package com.tim15.sessionbeans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.hibernate.mapping.DenormalizedTable;

import com.tim15.model.DnevnoStanjeRacuna;

@Stateless
@Local(DnevnoStanjeRacunaDaoLocal.class)
public class DnevnoStanjeRacunaDaoBean extends GenericDaoBean<DnevnoStanjeRacuna, Integer> implements DnevnoStanjeRacunaDaoLocal{

	@Override
	public DnevnoStanjeRacuna getPoslednjeStanje(String brojRacuna) {

		String query = "SELECT DISTINCT dsr FROM DnevnoStanjeRacuna dsr WHERE dsr.racuni.brojRacuna = '" +
		brojRacuna + "' ORDER BY dsr.datumPrometa DESC" ;

		Query q = em.createQuery(query);
		List<DnevnoStanjeRacuna> result = q.getResultList();

		DnevnoStanjeRacuna dnevnoStanjeRacuna = null;

		if(!result.isEmpty()){
			dnevnoStanjeRacuna = result.get(0);
		}

		return dnevnoStanjeRacuna;
	}

}
