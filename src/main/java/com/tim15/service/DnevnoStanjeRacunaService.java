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

import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;



@Path("/dnevnostanjeracuna")
public class DnevnoStanjeRacunaService {

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	private static Logger log = Logger.getLogger(DnevnoStanjeRacunaService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DnevnoStanjeRacuna>findAll() {
		List<DnevnoStanjeRacuna> lista = dnevnoStanjeRacunaDao.findAll();

		return dnevnoStanjeRacunaDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DnevnoStanjeRacuna findById(@PathParam("id") String id) {
		DnevnoStanjeRacuna retVal = null;
		try {
			retVal = dnevnoStanjeRacunaDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DnevnoStanjeRacuna entity) {
		Response response = null;

		try {
			dnevnoStanjeRacunaDao.persist(entity);
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
    public DnevnoStanjeRacuna update(DnevnoStanjeRacuna entity) {

		entity.setRacuni(racuniDao.findById(entity.getRacuni().getRacuniId()));

		DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanjeRacunaDao.findById(entity.getDnevnoStanjeRacunaId());
		dnevnoStanjeRacuna.setAll(entity);

    	DnevnoStanjeRacuna retVal = null;
        try {
        	retVal = dnevnoStanjeRacunaDao.merge(dnevnoStanjeRacuna);
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
			dnevnoStanjeRacunaDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
