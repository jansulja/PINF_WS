package com.tim15.sessionbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.tim15.model.Banka;
import com.tim15.model.FizickoLice;
import com.tim15.model.Racuni;
import com.tim15.service.KlijentService;
import com.tim15.util.BankaUtil;


@Stateless
@Local(FizickoLiceDaoLocal.class)
public class FizickoLiceDaoBean extends GenericDaoBean<FizickoLice, Integer> implements FizickoLiceDaoLocal {

	private static Logger log = Logger.getLogger(KlijentService.class);

	@EJB
	private BankaDaoLocal bankaDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	@Override
	public void register(FizickoLice fizickoLice) throws NoSuchFieldException {

		log.info("registracija fizickog lica: " + fizickoLice.toString());
		this.persist(fizickoLice);

		Banka banka = bankaDao.findById(fizickoLice.getIdBanka());

		//Racuni racun = new Racuni(BankaUtil.generateBrojRacuna(banka), new Date(), true, fizickoLice, banka, 0);
		//racuniDao.persist(racun);

	}

}
