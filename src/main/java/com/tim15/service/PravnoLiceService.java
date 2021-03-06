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

import com.tim15.model.PravnoLice;
import com.tim15.sessionbeans.KlijentDaoLocal;
import com.tim15.sessionbeans.PravnoLiceDaoLocal;



@Path("/pravnolice")
public class PravnoLiceService {

	@EJB
	private PravnoLiceDaoLocal pravnoLiceDao;

	@EJB
	private KlijentDaoLocal klijentDao;


	private static Logger log = Logger.getLogger(PravnoLiceService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PravnoLice> findAll() {
		return pravnoLiceDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PravnoLice findById(@PathParam("id") String id) {
		PravnoLice retVal = null;
		try {
			retVal = pravnoLiceDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PravnoLice entity) {
		Response response = null;

		try {
			pravnoLiceDao.persist(entity);
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
    public PravnoLice update(PravnoLice entity) {


		PravnoLice pravnoLice = pravnoLiceDao.findById(entity.getKlijentId());
		pravnoLice.setAll(entity);

    	PravnoLice retVal = null;
        try {
        	pravnoLiceDao.merge(pravnoLice);
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
        	pravnoLiceDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
