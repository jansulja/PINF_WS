package com.tim15.sessionbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.tim15.model.Banka;
import com.tim15.model.PravnoLice;
import com.tim15.model.Racuni;
import com.tim15.util.BankaUtil;


@Stateless
@Local(PravnoLiceDaoLocal.class)
public class PravnoLiceDaoBean extends GenericDaoBean<PravnoLice, Integer> implements PravnoLiceDaoLocal {

	private static Logger log = Logger.getLogger(PravnoLiceDaoBean.class);

	@EJB
	private BankaDaoLocal bankaDao;


	@EJB
	private RacuniDaoLocal racuniDao;


	@Override
	public void register(PravnoLice pravnoLice) throws NoSuchFieldException {

		log.info("registracija pravnog lica: " + pravnoLice.toString());
		this.persist(pravnoLice);

		Banka banka = bankaDao.findById(pravnoLice.getIdBanka());

		//Racuni racun = new Racuni(BankaUtil.generateBrojRacuna(banka), new Date(), true, pravnoLice, banka,0);
		//racuniDao.persist(racun);

	}



}
