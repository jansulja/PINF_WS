package com.tim15.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tim15.model.Racuni;
import com.tim15.model.view.NalogZaUplatu;
import com.tim15.sessionbeans.RacuniDaoLocal;

@Path("/banka")
public class BankaService {

	@EJB
	private RacuniDaoLocal racuniDao;

	@POST
	@Path("uplata")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object uplata(NalogZaUplatu nalogZaUplatu) {

		racuniDao.addFunds(nalogZaUplatu.getRacunPrimaoca(), nalogZaUplatu.getIznos());
		return Response.ok().build();

	}
}
