package com.tim15.obrade.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sun.org.apache.xerces.internal.util.Status;
import com.tim15.model.obrade.Nalog;
import com.tim15.model.xml.util.XmlManager;
import com.tim15.sessionbeans.AnalitikaIzvodaDaoLocal;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
import com.tim15.sessionbeans.KliringDaoLocal;
import com.tim15.sessionbeans.NaseljenoMestoDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;
import com.tim15.sessionbeans.StavkaKliringaDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;
import com.tim15.sessionbeans.VrstePlacanjaDaoLocal;

@Path("/mt102")
public class MT102Service {

	private static Logger log = Logger.getLogger(MT102Service.class);

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	@EJB
	private ValutaDaoLocal valutaDao;

	@EJB
	private BankaDaoLocal bankaDao;

	@EJB
	private KliringDaoLocal kliringDao;

	@EJB
	private StavkaKliringaDaoLocal stavkaKliringaDao;

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao;

	@EJB
	private VrstePlacanjaDaoLocal vrstePlacanjaDao;

	@EJB
	private AnalitikaIzvodaDaoLocal analitikaIzvodaDao;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateMT102() {



		XmlManager.generateMT102(kliringDao.getNext());

		return Response.status(javax.ws.rs.core.Response.Status.OK).build();

	}



}
