package com.tim15.service;

import java.util.List;

import javax.ejb.EJB;
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

import com.tim15.model.Zaposleni;
import com.tim15.model.Drzava;
import com.tim15.model.FizickoLice;
import com.tim15.model.Zaposleni;
import com.tim15.model.PravnoLice;
import com.tim15.sessionbeans.FizickoLiceDaoLocal;
import com.tim15.sessionbeans.ZaposleniDaoLocal;
import com.tim15.sessionbeans.PravnoLiceDaoLocal;

@Path("/zaposleni")
public class ZaposleniService {

	@EJB
	private ZaposleniDaoLocal zaposleniDao;

	@Context
	HttpServletRequest request;

	private static Logger log = Logger.getLogger(ZaposleniService.class);

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object login(Zaposleni sentUser) {
		Zaposleni zaposleni = null;

		try {
			zaposleni = zaposleniDao.login(sentUser.getEmail(), sentUser.getPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		if (zaposleni == null) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}

		zaposleni.setPassword("");

		return zaposleni;
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("logout")
	public Response logout(){

		zaposleniDao.logout();

		return Response.status(Status.OK).build();

	}


	@GET
	@Path("isLogged")
	@Produces(MediaType.APPLICATION_JSON)
	public Zaposleni status() {
		Zaposleni zaposleni = (Zaposleni) request.getSession().getAttribute("zaposleni");

		return zaposleni;
	}












}
