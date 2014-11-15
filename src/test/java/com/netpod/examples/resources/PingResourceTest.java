package com.netpod.examples.resources;
import com.netpod.examples.resources.PingResource;

import io.dropwizard.testing.junit.ResourceTestRule;

import org.junit.ClassRule;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
public class PingResourceTest {
	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder()
			.addResource(new PingResource())
			.build();

	@Test
	public void testGetPerson() {
		assertThat(resources.client().resource("/ping").get(String.class))
				.isEqualTo("{\"answer\": \"pong\"}");
	}
}
