package com.netpod.examples.dao;

import javax.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.netpod.domain.Person;

public class PersonDao extends AbstractDAO<Person> {

	@Inject
	public PersonDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Person persist(Person entity) throws HibernateException {
		return super.persist(entity);
	}

}
