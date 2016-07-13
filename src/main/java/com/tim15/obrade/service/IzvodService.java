package com.tim15.obrade.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.tim15.model.Banka;
import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Klijent;
import com.tim15.model.Racuni;
import com.tim15.model.Zaposleni;
import com.tim15.model.xml.util.XmlManager;
import com.tim15.sessionbeans.AnalitikaIzvodaDaoLocal;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.KliringDaoLocal;
import com.tim15.sessionbeans.NaseljenoMestoDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;
import com.tim15.sessionbeans.StavkaKliringaDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;
import com.tim15.sessionbeans.VrstePlacanjaDaoLocal;

@Path("/izvod")
public class IzvodService {

	private static Logger log = Logger.getLogger(IzvodService.class);

	@Context
	private HttpServletRequest request;

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	@EJB
	private ValutaDaoLocal valutaDao;

	@EJB
	private BankaDaoLocal bankaDao;
	@EJB
	private KlijentDaoLocal klijentDao;

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
	@Path("{klijentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("klijentId") String klijentId) {

		Response response = null;

		Zaposleni zaposleni = (Zaposleni) request.getSession().getAttribute("zaposleni");
		Klijent klijent = klijentDao.findById(Integer.parseInt(klijentId));
		Banka banka = zaposleni.getBanka();
		Racuni racun = klijentDao.getRacunUBanci(Integer.parseInt(klijentId), banka.getBankaId());
		DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanjeRacunaDao.getPoslednjeStanje(racun.getBrojRacuna());

		Date date = dnevnoStanjeRacuna.getDatumPrometa();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dPrometa = sdf.format(date);
		String dToday = sdf.format(today);


		if(dPrometa.equals(dToday)){
			XmlManager.generateIzvod(racun.getBrojRacuna(), klijent, dnevnoStanjeRacuna);
			response = Response.status(Status.OK).build();
		}else{
			String errorMessage = "Nema transakcija za danasnji dan.";
			response = Response.status(Response.Status.NOT_FOUND).entity("{\"errorMessage\": \""+ errorMessage +"\" }").build();
		}



		return response;

    }



}
