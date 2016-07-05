package com.tim15.service;

import java.util.List;
import java.util.Set;

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

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.VrstePlacanja;
import com.tim15.sessionbeans.VrstePlacanjaDaoLocal;



@Path("/vrsteplacanja")
public class VrstePlacanjaService {

	@EJB
	private VrstePlacanjaDaoLocal vrstePlacanjaDao;


	private static Logger log = Logger.getLogger(VrstePlacanjaService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VrstePlacanja> izlistajDrzave() {
		return vrstePlacanjaDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VrstePlacanja findById(@PathParam("id") String id) {
		VrstePlacanja retVal = null;
		try {
			retVal = vrstePlacanjaDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VrstePlacanja entity) {
		Response response = null;

		try {
			vrstePlacanjaDao.persist(entity);
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
    public VrstePlacanja update(VrstePlacanja entity) {

		VrstePlacanja originalEntity = vrstePlacanjaDao.findById(entity.getVrstaPlacanjaId());

		Set<AnalitikaIzvoda> analitikaIzvoda = originalEntity.getAnalitikaIzvoda();

		entity.setAnalitikaIzvoda(analitikaIzvoda);

    	VrstePlacanja retVal = null;
        try {
        	retVal = vrstePlacanjaDao.merge(entity);
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
        	vrstePlacanjaDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
