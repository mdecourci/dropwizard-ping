package com.netpod.examples.resources;

import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.netpod.examples.Resources;
import com.netpod.examples.services.PingService;
import com.netpod.examples.task.PingTask;

@Path("/ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingResource.class);
	
	private final PingService pingService;
    private final PingTask pingTask;
    private final Resources resources;
	
	@Inject
	public PingResource(Resources resources, @Named("pingService") PingService pingService, PingTask task) {
		super();
		this.pingService = pingService;
		this.pingTask = task;
		this.resources = resources;
	}

	@UnitOfWork
	@GET
	@Timed
	public String pong() {
		LOGGER.debug("pong()");
		
		pingTask.send("execute: -");
		
		return pingService.execute();
	}
}
