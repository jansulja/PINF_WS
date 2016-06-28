package com.tim15.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.tim15.model.FizickoLice;
import com.tim15.model.Klijent;
import com.tim15.model.PravnoLice;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.PravnoLiceDaoLocal;

@Path("/klijent")
public class KlijentService {

	@EJB
	private KlijentDaoLocal klijentDao;
	@EJB
	private PravnoLiceDaoLocal pravnoLiceDao;
	@EJB
	private FizickoLiceDaoLocal fizickoLiceDao;

	private static Logger log = Logger.getLogger(KlijentService.class);

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object login(Klijent sentUser) {
		Klijent klijent = null;

		try {
			klijent = klijentDao.login(sentUser.getEmail(), sentUser.getPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		if (klijent == null) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}

		klijent.setPassword("");

		return klijent;
	}

	@POST
	@Path("register/pravno")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object register(PravnoLice sentUser) {

		pravnoLiceDao.register(sentUser);
		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("register/fizicko")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object register(FizickoLice sentUser) {

		fizickoLiceDao.register(sentUser);
		return Response.status(Response.Status.OK).build();
	}

}
