package com.netpod.examples;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.yammer.tenacity.core.bundle.BaseTenacityBundleConfigurationFactory;
import com.yammer.tenacity.core.config.TenacityConfiguration;
import com.yammer.tenacity.core.properties.TenacityPropertyKey;
import com.yammer.tenacity.core.properties.TenacityPropertyKeyFactory;

public class CompletieTenacityBundleConfigurationFactory extends BaseTenacityBundleConfigurationFactory<PingConfiguration> {

	@Override
	public Map<TenacityPropertyKey, TenacityConfiguration> getTenacityConfigurations(
			PingConfiguration configuration) {
		final ImmutableMap.Builder<TenacityPropertyKey, TenacityConfiguration> builder = ImmutableMap
				.builder();

		builder.put(CompletieDependencyKeys.PING_SERVICE, configuration
				.getRanking().getHystrixUserConfig());

		return builder.build();
	}

	@Override
	public TenacityPropertyKeyFactory getTenacityPropertyKeyFactory(
			PingConfiguration applicationConfiguration) {
		return new CompletieDependencyKeyFactory();
	}
}
