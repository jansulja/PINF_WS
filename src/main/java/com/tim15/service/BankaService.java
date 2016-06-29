package com.tim15.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tim15.model.view.NalogZaUplatu;

@Path("/banka")
public class BankaService {


	@POST
	@Path("uplata")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object uplata(NalogZaUplatu nalogZaUplatu) {



		return null;

	}
}
