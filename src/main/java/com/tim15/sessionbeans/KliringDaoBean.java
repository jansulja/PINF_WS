package com.tim15.sessionbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.tim15.model.Kliring;

import sun.util.logging.resources.logging;



@Stateless
@Local(KliringDaoLocal.class)
public class KliringDaoBean extends GenericDaoBean<Kliring, Integer> implements KliringDaoLocal {

	@Override
	public Kliring getNext() {

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		String time = sdf.format(now);


		String query = "SELECT DISTINCT k FROM Kliring k WHERE k.datumKliringa > '"+ time +"' ORDER BY k.datumKliringa ASC" ;

		Query q = em.createQuery(query);
				List<Kliring> result = q.getResultList();

				Kliring Kliring = null;

				if(!result.isEmpty()){
					Kliring = result.get(0);
				}

				return Kliring;


	}




}
