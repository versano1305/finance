package config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class VersAplication extends ResourceConfig {
    /**
	* Register JAX-RS application components.
	*/
	public VersAplication(){
		register(RequestContextFilter.class);
//		register(PodcastRestService.class);
		register(JacksonFeature.class);
	}
}
