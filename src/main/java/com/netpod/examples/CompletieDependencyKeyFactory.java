package com.netpod.examples;

import com.yammer.tenacity.core.properties.TenacityPropertyKey;
import com.yammer.tenacity.core.properties.TenacityPropertyKeyFactory;

public class CompletieDependencyKeyFactory implements
		TenacityPropertyKeyFactory {

	@Override
	public TenacityPropertyKey from(String value) {
		return CompletieDependencyKeys.valueOf(value.toUpperCase());
	}

}
