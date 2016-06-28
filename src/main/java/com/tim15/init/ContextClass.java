package com.tim15.init;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tim15.model.Klijent;
import com.tim15.sessionbeans.KlijentDaoLocal;

public class ContextClass implements ServletContextListener {

	@EJB
	private KlijentDaoLocal klijentDao;



	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {


	}

}
