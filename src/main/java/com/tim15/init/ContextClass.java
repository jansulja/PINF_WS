package com.tim15.init;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sun.jmx.snmp.Timestamp;
import com.tim15.model.Banka;
import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Drzava;
import com.tim15.model.FizickoLice;
import com.tim15.model.Kliring;
import com.tim15.model.NaseljenoMesto;
import com.tim15.model.Racuni;
import com.tim15.model.Valuta;
import com.tim15.model.VrstePlacanja;
import com.tim15.model.Zaposleni;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
import com.tim15.sessionbeans.DrzavaDaoLocal;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.KliringDaoLocal;
import com.tim15.sessionbeans.NaseljenoMestoDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;
import com.tim15.sessionbeans.VrstePlacanjaDaoLocal;
import com.tim15.sessionbeans.ZaposleniDaoLocal;

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

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao;

	@EJB
	private VrstePlacanjaDaoLocal vrstePlacanjaDao;

	@EJB
	private ZaposleniDaoLocal zaposleniDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	@EJB
	private KliringDaoLocal kliringDao;

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		//init();
	}


	public void init(){

		Banka b1 = new Banka("115", "7439857", "TELENOR BANKA, AD, BEOGRAD", "adresa 1", "telenor@tel.com", "www.tel.com", "063/453-234", "063/453-234","1111111","222", true, null, null);
		Banka b2 = new Banka("125", "7439857", "PIRAEUS BANK, AD, BEOGRAD", "adresa 2", "pireus@tel.com", "www.pire.com", "063/453-234", "063/453-234","3333333","444", true, null, null);
		Banka b3 = new Banka("160", "7439857", "BANCA INTESA, AD, BEOGRAD", "adresa 3", "intesa@tel.com", "www.intesa.com", "063/453-234", "063/453-234","6666666","777", true, null, null);


		FizickoLice fl1 = new FizickoLice("063/4597-487", "shuky11@gmail.com", "Jana Kolara 34", "****", 1, null, "Jan Sulja", new Date(1993, 12, 17), "M", 456789, 1712993850);
		FizickoLice fl2 = new FizickoLice("060/8978-457", "pera@gmail.com", "Pere Perica 34", "****", 1, null, "Pera Peric", new Date(1993, 12, 17), "M", 78945, 125458);
		FizickoLice fl3 = new FizickoLice("064/7894-454", "zika@gmail.com", "Pere Perica 34", "****", 1, null, "Zika Zikic", new Date(1993, 12, 17), "M", 78945, 125458);



		Drzava d1 = new Drzava(0, "Srbija", null, null);
		Drzava d2 = new Drzava(0, "Crna Gora", null, null);
		Drzava d3 = new Drzava(0, "Bosna i Hercegovina", null, null);

		Valuta v1 = new Valuta("RSD", "Srpski Dinar", false, d1, null, null, null, null);

		NaseljenoMesto nm1 = new NaseljenoMesto(0, "Novi Sad", "21000", null, d1);
		NaseljenoMesto nm2 = new NaseljenoMesto(0, "Beograd", "11000", null, d1);

		VrstePlacanja vp1 = new VrstePlacanja(0, "Transakcija", 189	, null);

		Zaposleni z1 = new Zaposleni(0, "Nikola", "Nikolic", "z1@z1.com", "z1", b1);
		Zaposleni z2 = new Zaposleni(0, "Marko", "Markovic", "z2@z2.com", "z2", b2);
		Zaposleni z3 = new Zaposleni(0, "Filip", "Filipovic", "z3@z3.com", "z3", b3);

		java.util.Date now = new java.util.Date();
		Date sqlDate = new Date(now.getTime());
		Racuni r1 = new Racuni(0, "115-111111-11", sqlDate, true, fl1, b1, 0);
		Racuni r2 = new Racuni(0, "115-222222-11", sqlDate, true, fl2, b1, 0);
		Racuni r3 = new Racuni(0, "125-111111-11", sqlDate, true, fl3, b2, 0);
		r1.setValuta(v1);
		r2.setValuta(v1);
		r3.setValuta(v1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(now);

		java.sql.Timestamp t1 = java.sql.Timestamp.valueOf(date + " 10:15:00");
		java.sql.Timestamp t2 = java.sql.Timestamp.valueOf(date + " 12:15:00");
		java.sql.Timestamp t3 = java.sql.Timestamp.valueOf(date + " 14:15:00");


		Kliring k1 = new Kliring(0, t1, null);
		Kliring k2 = new Kliring(0, t2, null);
		Kliring k3 = new Kliring(0, t3, null);

		DnevnoStanjeRacuna dsr1 = new DnevnoStanjeRacuna(sqlDate, 0, 30000, 0, 30000, r1, null);
		DnevnoStanjeRacuna dsr2 = new DnevnoStanjeRacuna(sqlDate, 0, 500000, 0, 500000, r2, null);
		DnevnoStanjeRacuna dsr3 = new DnevnoStanjeRacuna(sqlDate, 0, 20000, 0, 20000, r3, null);


		try {
			bankaDao.persist(b1);
			bankaDao.persist(b2);
			bankaDao.persist(b3);

			fizickoLiceDao.persist(fl1);
			fizickoLiceDao.persist(fl2);
			fizickoLiceDao.persist(fl3);

			drzavaDao.persist(d1);
			drzavaDao.persist(d2);
			drzavaDao.persist(d3);

			valutaDao.persist(v1);

			naseljenoMestoDao.persist(nm1);
			naseljenoMestoDao.persist(nm2);

			vrstePlacanjaDao.persist(vp1);

			zaposleniDao.persist(z1);
			zaposleniDao.persist(z2);
			zaposleniDao.persist(z3);


			racuniDao.persist(r1);
			racuniDao.persist(r2);
			racuniDao.persist(r3);

			kliringDao.persist(k1);
			kliringDao.persist(k2);
			kliringDao.persist(k3);

			dnevnoStanjeRacunaDao.persist(dsr1);
			dnevnoStanjeRacunaDao.persist(dsr2);
			dnevnoStanjeRacunaDao.persist(dsr3);


		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

}
