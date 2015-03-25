package org.jboss.kiefuse.demo;

import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
@Path("/ticketingService/")
public class TicketingRestService {
	@GET
	@Produces("text/plain")
	@Path("/ticketing/{id}/")
	public String doIt(@PathParam("id") String id) {
		Random rd = new Random();
		int no = rd.nextInt();
		String number = id+no;
		System.out.println("rest service value" + number);
		return number;
	}

}
