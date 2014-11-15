package com.netpod.examples.services.impl;

import org.netpod.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netpod.examples.Resources;
import com.netpod.examples.dao.PersonDao;
import com.netpod.examples.services.PingService;
import com.netpod.examples.task.PingTask;

public class PingServiceImpl implements PingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingServiceImpl.class);

    private final PingTask pingTask;
    private final Resources resources;
    private final PersonDao personDao; 

    @javax.inject.Inject
	public PingServiceImpl(PingTask pingTask, Resources resources,
			PersonDao personDao) {
		super();
		this.pingTask = pingTask;
		this.resources = resources;
		this.personDao = personDao;
	}

	@Override
	public String execute() {
		LOGGER.info("execute(): mediaType={}, apiKey={}, root={}", new Object[]{resources.getMediaType(), resources.getApiKey(), resources.getRoot()});
		String msg = "{\"answer\": \"pong\"}";
		pingTask.send(msg);
		Person entity = new Person();
		entity.setAge(20);
		entity.setFirstName("Michael");
		entity.setLastName("James");
		personDao.persist(entity);
		return msg;
	}

}
