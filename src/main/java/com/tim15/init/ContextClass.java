package com.tim15.init;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tim15.model.Banka;
import com.tim15.model.Klijent;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;

public class ContextClass implements ServletContextListener {

	@EJB
	private KlijentDaoLocal klijentDao;

	@EJB
	private BankaDaoLocal bankaDao;



	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Banka b1 = new Banka("115", "7439857", "TELENOR BANKA, AD, BEOGRAD", "adresa 1", "telenor@tel.com", "www.tel.com", "063/453-234", "063/453-234", true, null, null);
		Banka b2 = new Banka("125", "7439857", "PIRAEUS BANK, AD, BEOGRAD", "adresa 2", "pireus@tel.com", "www.pire.com", "063/453-234", "063/453-234", true, null, null);
		Banka b3 = new Banka("160", "7439857", "BANCA INTESA, AD, BEOGRAD", "adresa 3", "intesa@tel.com", "www.intesa.com", "063/453-234", "063/453-234", true, null, null);


		//String telefon, String email, String adresa, String password
		//Klijent klijent = new Klijent("063/111-111", "k1@k1.com", "Vladimira Nazora 12","k1");

//		try {
//			bankaDao.persist(b1);
//			bankaDao.persist(b2);
//			bankaDao.persist(b3);
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try{
//			klijentDao.persist(klijent);
//		} catch (NoSuchFieldException e){
//			e.printStackTrace();
//		}

	}

}
