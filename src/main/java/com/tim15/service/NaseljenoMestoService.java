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

import com.tim15.model.Drzava;
import com.tim15.model.NaseljenoMesto;
import com.tim15.sessionbeans.DrzavaDaoLocal;
import com.tim15.sessionbeans.NaseljenoMestoDaoLocal;



@Path("/naseljenomesto")
public class NaseljenoMestoService {

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao;

	@EJB
	private DrzavaDaoLocal drzavaDao;

	private static Logger log = Logger.getLogger(NaseljenoMestoService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NaseljenoMesto> izlistajDrzave() {
		return naseljenoMestoDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NaseljenoMesto findById(@PathParam("id") String id) {
		NaseljenoMesto retVal = null;
		try {
			retVal = naseljenoMestoDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }

	@GET
	@Path("/drzava/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Drzava getDrzava(@PathParam("id") String id) {
		NaseljenoMesto retVal = null;
		try {
			retVal = naseljenoMestoDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal.getDrzava();
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(NaseljenoMesto entity) {
		Response response = null;

		try {
			naseljenoMestoDao.persist(entity);
			response = Response.status(Status.OK).build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();

		}
		return response;
    }



	@PUT
    @Path("{naseljenoMestiId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public NaseljenoMesto update(NaseljenoMesto entity ) {



    	NaseljenoMesto retVal = null;

    	NaseljenoMesto naseljenoMesto = naseljenoMestoDao.findById(entity.getNaseljenoMestoId());
    	naseljenoMesto.setNaziv(entity.getNaziv());
    	naseljenoMesto.setpTToznaka(entity.getpTToznaka());
    	naseljenoMesto.setDrzava(drzavaDao.findById(entity.getDrzava().getDrzavaId()));

        try {
        	//entity.setNaseljenoMestoId(id);
        	retVal = naseljenoMestoDao.merge(naseljenoMesto);
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
			naseljenoMestoDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
