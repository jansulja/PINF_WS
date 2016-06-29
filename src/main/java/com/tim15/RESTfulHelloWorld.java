package com.tim15;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;



@Path("/test")
public class RESTfulHelloWorld
{
	private static Logger log = Logger.getLogger(RESTfulHelloWorld.class);

	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{

		log.info("testtrttt");

		String output = "<h1>Hello World!<h1>" +
				"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
		return Response.status(200).entity(output).build();
	}
}
