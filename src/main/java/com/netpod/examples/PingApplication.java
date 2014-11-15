package com.netpod.examples;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.hibernate.SessionFactory;
import org.joda.time.DateTimeZone;
import org.netpod.domain.Person;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.netpod.examples.health.PingHealthCheck;
import com.netpod.examples.resources.PingResource;
import com.netpod.examples.services.PingService;
import com.netpod.examples.services.impl.PingServiceImpl;
import com.sun.jersey.api.client.Client;
import com.yammer.tenacity.core.bundle.TenacityBundleBuilder;

public class PingApplication extends Application<PingConfiguration> {
	public static void main(String[] args) throws Exception {
		new PingApplication().run(args);
	}

	@Override
	public String getName() {
		return "ping-app";
	}
	private final HibernateBundle<PingConfiguration> hibernate = new HibernateBundle<PingConfiguration>(Person.class) {
	    @Override
	    public DataSourceFactory getDataSourceFactory(PingConfiguration configuration) {
	        return configuration.getDataSourceFactory();
	    }
	};
	@Override
	public void initialize(Bootstrap<PingConfiguration> bootstrap) {
		DateTimeZone.setDefault(DateTimeZone.UTC);
		 bootstrap.addBundle(hibernate);
		 bootstrap.addBundle(TenacityBundleBuilder
                 .<PingConfiguration> newBuilder()
                 .configurationFactory(new CompletieTenacityBundleConfigurationFactory())
                 .build());
		 }

	@Override
	public void run(PingConfiguration configuration, Environment environment) throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
		        final com.sun.jersey.api.client.Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
		                .build(getName());
				
	            bind(PingConfiguration.class).toInstance(configuration); // if someone would like to @Inject PingConfiguration
	            bind(Resources.class).toInstance(configuration.getResources()); // for Resource
	            bind(Client.class).toInstance(client); 
	            bind(SessionFactory.class).toInstance(hibernate.getSessionFactory()); 

	            bind(PingService.class)
		        .annotatedWith(Names.named("pingService"))
		        .to(PingServiceImpl.class);
			}
			
		});
	    environment.jersey().register(injector.getInstance(PingResource.class));
		environment.healthChecks().register("Ping health check",injector.getInstance(PingHealthCheck.class));
//		 PingService pingService = new PingServiceImpl();
//		environment.jersey().register(new PingResource(pingService));
//		environment.healthChecks().register("Ping health check", new PingHealthCheck());
	}
}
