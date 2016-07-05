package com.tim15.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import com.tim15.model.KursUValuti;
import com.tim15.model.KursnaLista;
import com.tim15.sessionbeans.KursnaListaDaoLocal;



@Path("/kursnalista")
public class KursnaListaService {

	@EJB
	private KursnaListaDaoLocal kursnaListaDao;


	private static Logger log = Logger.getLogger(KursnaListaService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<KursnaLista> izlistajDrzave() {
		return kursnaListaDao.findAll();
	}


	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public KursnaLista findById(@PathParam("id") String id) {
		KursnaLista retVal = null;
		try {
			retVal = kursnaListaDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
    }


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(KursnaLista entity) {
		Response response = null;

		try {
			kursnaListaDao.persist(entity);
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
    public KursnaLista update(KursnaLista entity) {

    	KursnaLista retVal = null;
        try {
        	entity.setKursUValuti(new HashSet<KursUValuti>());
        	retVal = kursnaListaDao.merge(entity);
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
			kursnaListaDao.remove(id);
        	response = Response.status(Status.OK).build();
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    	return response;
    }

}
