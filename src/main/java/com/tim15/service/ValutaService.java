package com.tim15.service;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder.In;
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

import com.tim15.model.Valuta;
import com.tim15.sessionbeans.DrzavaDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;



@Path("/valuta")
public class ValutaService {

	@EJB
	private ValutaDaoLocal valutaDao;

	@EJB
	private DrzavaDaoLocal drzavaDao;


	private static Logger log = Logger.getLogger(ValutaService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Valuta> findByAll() {
		return valutaDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Valuta findById(@PathParam("id") String id) {
		Valuta retVal = null;
		try {
			retVal = valutaDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Valuta entity) {
		Response response = null;

		try {
			valutaDao.persist(entity);
			response = Response.status(Status.OK).build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Ne postoji drzava sa sifrom : "+ entity.getDrzava().getDrzavaId() +"\"}").build();

		}
		return response;
    }


	@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Valuta update(Valuta entity) {

		Valuta valuta = valutaDao.findById(entity.getValutaId());
		valuta.setAll(entity.getZvanicnaSifra(), entity.getNaziv(), entity.isDomicilna(), drzavaDao.findById(entity.getDrzava().getDrzavaId()));

    	Valuta retVal = null;
        try {
        	retVal = valutaDao.merge(valuta);
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
        	valutaDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
