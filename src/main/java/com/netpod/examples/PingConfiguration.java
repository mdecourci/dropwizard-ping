package com.netpod.examples;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PingConfiguration extends Configuration {
	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();

	@JsonProperty
	private Resources resources;

	@Valid
	@NotNull
	@JsonProperty
	private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}

	public void setDataSourceFactory(DataSourceFactory database) {
		this.dataSourceFactory = database;
	}

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	public JerseyClientConfiguration getJerseyClientConfiguration() {
		return httpClient;
	}

	public void setHttpClient(JerseyClientConfiguration httpClient) {
		this.httpClient = httpClient;
	}
}
