package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.tim15.model.FizickoLice;
import com.tim15.service.KlijentService;


@Stateless
@Local(FizickoLiceDaoLocal.class)
public class FizickoLiceDaoBean extends GenericDaoBean<FizickoLice, Integer> implements FizickoLiceDaoLocal {

	private static Logger log = Logger.getLogger(KlijentService.class);
	@Override
	public void register(FizickoLice fizickoLice) throws NoSuchFieldException {

		log.info("registracija fizickog lica: " + fizickoLice.toString());
		this.persist(fizickoLice);
	}

}
