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

import com.tim15.model.Ukidanje;
import com.tim15.sessionbeans.RacuniDaoLocal;
import com.tim15.sessionbeans.UkidanjeDaoLocal;



@Path("/ukidanje")
public class UkidanjeService {

	@EJB
	private UkidanjeDaoLocal ukidanjeDao;

	@EJB
	private RacuniDaoLocal racuniDao;


	private static Logger log = Logger.getLogger(UkidanjeService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ukidanje> izlistajDrzave() {
		return ukidanjeDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ukidanje findById(@PathParam("id") String id) {
		Ukidanje retVal = null;
		try {
			retVal = ukidanjeDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Ukidanje entity) {
		Response response = null;

		racuniDao.ukiniRacun(entity);

//		try {
//			ukidanjeDao.persist(entity);
//			response = Response.status(Status.OK).build();
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
//
//		}
		return response;
    }


	@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Ukidanje update(Ukidanje entity) {

    	Ukidanje retVal = null;
        try {
        	retVal = ukidanjeDao.merge(entity);
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
        	ukidanjeDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
