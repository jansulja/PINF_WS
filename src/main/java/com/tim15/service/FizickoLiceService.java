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

import com.tim15.model.FizickoLice;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.KlijentDaoLocal;



@Path("/fizickolice")
public class FizickoLiceService {

	@EJB
	private FizickoLiceDaoLocal fizickoLiceDao;

	@EJB
	private KlijentDaoLocal klijentDao;


	private static Logger log = Logger.getLogger(FizickoLiceService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FizickoLice> findAll() {
		return fizickoLiceDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FizickoLice findById(@PathParam("id") String id) {
		FizickoLice retVal = null;
		try {
			retVal = fizickoLiceDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(FizickoLice entity) {
		Response response = null;

		try {
			fizickoLiceDao.persist(entity);
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
    public FizickoLice update(FizickoLice entity) {

		FizickoLice fizickoLice = fizickoLiceDao.findById(entity.getKlijentId());
		fizickoLice.setAll(entity);

    	FizickoLice retVal = null;
        try {
        	//retVal = (FizickoLice) klijentDao.merge(entity);
        	fizickoLiceDao.merge(fizickoLice);
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
        	fizickoLiceDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
