package com.netpod.examples.health;

import javax.inject.Named;

import com.codahale.metrics.health.HealthCheck;
@Named
public class PingHealthCheck extends HealthCheck {
	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}
