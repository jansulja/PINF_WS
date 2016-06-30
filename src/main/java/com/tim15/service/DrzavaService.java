package com.tim15.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.tim15.model.FizickoLice;
import com.tim15.model.Klijent;
import com.tim15.model.PravnoLice;
import com.tim15.sessionbeans.DrzavaDaoLocal;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.PravnoLiceDaoLocal;

@Path("/drzava")
public class DrzavaService {

	@EJB
	private DrzavaDaoLocal drzavaDao;


	private static Logger log = Logger.getLogger(DrzavaService.class);





	@GET
	@Path("list")
//	@Produces(MediaType.TEXT_HTML)
	public String izlistajDrzave() {



		Response response;
		drzavaDao.findAll();
		System.out.println(drzavaDao.findAll().size());

		return Integer.toString(drzavaDao.findAll().size()) ;

	}

}
