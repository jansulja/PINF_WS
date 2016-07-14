package com.tim15.sessionbeans;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.hibernate.mapping.DenormalizedTable;

import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Klijent;
import com.tim15.model.view.DatumIzvestaja;

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

	@Override
	public List<DnevnoStanjeRacuna> getStanjeZaPeriod(DatumIzvestaja period) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		String datumOd = sdf.format(period.getDatumOd());
//		String datumDo = sdf.format(period.getDatumDo());

		String query = "SELECT DISTINCT dsr FROM DnevnoStanjeRacuna dsr WHERE dsr.datumPrometa >= :datumOd AND "
				+ "dsr.datumPrometa <= :datumDo AND "
				+ "dsr.racuni.klijent.klijentId = :klijentId";

		Query q = em.createQuery(query);
		q.setParameter("datumOd", period.getDatumOd());
		q.setParameter("datumDo", period.getDatumDo());
		q.setParameter("klijentId", period.getKlijentId());

		List<DnevnoStanjeRacuna> result = q.getResultList();

		return result;
	}

}
