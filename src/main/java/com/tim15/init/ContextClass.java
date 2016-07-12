package com.tim15.init;

import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tim15.model.Banka;
import com.tim15.model.Drzava;
import com.tim15.model.FizickoLice;
import com.tim15.model.Valuta;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.DrzavaDaoLocal;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;

public class ContextClass implements ServletContextListener {

	@EJB
	private KlijentDaoLocal klijentDao;

	@EJB
	private BankaDaoLocal bankaDao;

	@EJB
	private FizickoLiceDaoLocal fizickoLiceDao;

	@EJB
	private DrzavaDaoLocal drzavaDao;

	@EJB
	private ValutaDaoLocal valutaDao;


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Banka b1 = new Banka("115", "7439857", "TELENOR BANKA, AD, BEOGRAD", "adresa 1", "telenor@tel.com", "www.tel.com", "063/453-234", "063/453-234","1111111","222", true, null, null);
		Banka b2 = new Banka("125", "7439857", "PIRAEUS BANK, AD, BEOGRAD", "adresa 2", "pireus@tel.com", "www.pire.com", "063/453-234", "063/453-234","3333333","444", true, null, null);
		Banka b3 = new Banka("160", "7439857", "BANCA INTESA, AD, BEOGRAD", "adresa 3", "intesa@tel.com", "www.intesa.com", "063/453-234", "063/453-234","6666666","777", true, null, null);


		FizickoLice fl1 = new FizickoLice("060/0668***", "shuky11@gmail.com", "Jana Kolara 34", "****", 1, null, "Jan Sulja", new Date(1993, 12, 17), "M", 456789, 1712993850);
		FizickoLice fl2 = new FizickoLice("060/0668***", "pera@gmail.com", "Pere Perica 34", "****", 1, null, "Pera Peric", new Date(1993, 12, 17), "M", 78945, 125458);

		Drzava d1 = new Drzava(0, "Srbija", null, null);
		Drzava d2 = new Drzava(0, "Crna Gora", null, null);
		Drzava d3 = new Drzava(0, "Bosna i Hercegovina", null, null);

		Valuta v1 = new Valuta("RSD", "Srpski Dinar", false, d1, null, null, null, null);




//		try {
//			bankaDao.persist(b1);
//			bankaDao.persist(b2);
//			bankaDao.persist(b3);
//
//			fizickoLiceDao.persist(fl1);
//			fizickoLiceDao.persist(fl2);
//
//			drzavaDao.persist(d1);
//			drzavaDao.persist(d2);
//			drzavaDao.persist(d3);
//
//			valutaDao.persist(v1);
//
//
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//
	}

}
