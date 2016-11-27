package com.Route21.ws;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {	
	
	
	public JerseyConfig() {
		packages("com.Route21.ws.endpoint");
		packages("com.Route21.ws.exceptionmapper");
	}
	
	
}
