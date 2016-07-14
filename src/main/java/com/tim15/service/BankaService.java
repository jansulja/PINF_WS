package com.tim15.service;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.tim15.model.Banka;
import com.tim15.model.KursnaLista;
import com.tim15.model.Racuni;
import com.tim15.model.Zaposleni;
import com.tim15.model.view.NalogZaUplatu;
import com.tim15.model.xml.util.XmlManager;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;

@Path("/banka")
public class BankaService {

	@Context
	private HttpServletRequest request;

	@EJB
	private RacuniDaoLocal racuniDao;

	@EJB
	private BankaDaoLocal bankaDao;



	private static Logger log = Logger.getLogger(DrzavaService.class);

	@GET
	@Path("izvestaj")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateReport() {

		Zaposleni zaposleni = (Zaposleni) request.getSession().getAttribute("zaposleni");
		XmlManager.generateBankaIzvestaj(zaposleni.getBanka());


		return Response.ok().build();
    }


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Banka> findAll() {

		@SuppressWarnings("unused")
		List<Banka> lista = bankaDao.findAll();

		return bankaDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Banka findById(@PathParam("id") String id) {
		Banka retVal = null;
		try {
			retVal = bankaDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Banka entity) {
		Response response = null;

		try {
			bankaDao.persist(entity);
			response = Response.status(Status.OK).build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();

		}
		return response;
    }


	@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Banka update(Banka entity) {

		Banka originalEntity = bankaDao.findById(entity.getBankaId());

		Set<KursnaLista> kursnaLista = originalEntity.getKursnaLista();
		Set<Racuni> racuni = originalEntity.getRacuni();

		entity.setKursnaLista(kursnaLista);
		entity.setRacuni(racuni);

		Banka retVal = null;
        try {
        	retVal = bankaDao.merge(entity);
        } catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
    	Response response = null;

		try {
        	bankaDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

	@POST
	@Path("uplata")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object uplata(NalogZaUplatu nalogZaUplatu) {

		racuniDao.addFunds(nalogZaUplatu.getRacunPrimaoca(), nalogZaUplatu.getIznos());
		return Response.ok().build();

	}


}
