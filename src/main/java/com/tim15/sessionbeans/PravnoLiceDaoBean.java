package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.tim15.model.PravnoLice;
import com.tim15.service.KlijentService;


@Stateless
@Local(PravnoLiceDaoLocal.class)
public class PravnoLiceDaoBean extends GenericDaoBean<PravnoLice, Integer> implements PravnoLiceDaoLocal {

	private static Logger log = Logger.getLogger(PravnoLiceDaoBean.class);

	@Override
	public void register(PravnoLice pravnoLice) throws NoSuchFieldException {

		log.info("registracija pravnog lica: " + pravnoLice.toString());
		this.persist(pravnoLice);

	}

}
