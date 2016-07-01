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

import com.tim15.model.Racuni;
import com.tim15.sessionbeans.RacuniDaoLocal;



@Path("/racuni")
public class RacuniService {

	@EJB
	private RacuniDaoLocal racuniDao;


	private static Logger log = Logger.getLogger(RacuniService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Racuni> izlistajDrzave() {
		return racuniDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Racuni findById(@PathParam("id") String id) {
		Racuni retVal = null;
		try {
			retVal = racuniDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Racuni entity) {
		Response response = null;

		try {
			racuniDao.persist(entity);
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
    public Racuni update(Racuni entity) {

    	Racuni retVal = null;
        try {
        	retVal = racuniDao.merge(entity);
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
			racuniDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
