package com.tim15.sessionbeans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.tim15.model.VrstePlacanja;

@Stateless
@Local(VrstePlacanjaDaoLocal.class)
public class VrstePlacanjaDaoBean extends GenericDaoBean<VrstePlacanja, Integer> implements VrstePlacanjaDaoLocal {

	@Override
	public VrstePlacanja findByOznaka(int oznaka) {
		String query = "SELECT DISTINCT vp FROM VrstePlacanja vp WHERE vp.oznaka = '" +
				String.valueOf(oznaka) + "'";

				Query q = em.createQuery(query);
				List<VrstePlacanja> result = q.getResultList();

				VrstePlacanja vrstePlacanja = null;

				if(!result.isEmpty()){
					vrstePlacanja = result.get(0);
				}

				return vrstePlacanja;
	}



}
