package com.tim15.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.tim15.model.Klijent;
import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Drzava;
import com.tim15.model.FizickoLice;
import com.tim15.model.Klijent;
import com.tim15.model.PravnoLice;
import com.tim15.model.view.DatumIzvestaja;
import com.tim15.model.xml.util.XmlManager;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
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

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;

	private static Logger log = Logger.getLogger(KlijentService.class);


	@POST
	@Path("izvestaj")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response generisiIzvestaj(DatumIzvestaja period) {


		List<DnevnoStanjeRacuna> stanja = dnevnoStanjeRacunaDao.getStanjeZaPeriod(period);
		String naziv = klijentDao.getNaziv(period.getKlijentId());
		XmlManager.generateKlijentIzvestaj(stanja, naziv);



		return Response.ok().build();

	}




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
	public Object registerPravno(PravnoLice sentUser) {

		//TODO Validacija

		Response response = null;

		try {
			pravnoLiceDao.register(sentUser);
			response = Response.status(Response.Status.OK).build();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}
		return response;
	}

	@POST
	@Path("register/fizicko")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object registerFizicko(FizickoLice sentUser) {

		//TODO Validacija

		Response response = null;

		try {
			fizickoLiceDao.register(sentUser);
			response = Response.status(Response.Status.OK).build();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Klijent> findAll() {
		return klijentDao.findAll();
	}














}
