package org.manu.config;

import org.manu.endpoint.CitySearchServiceEndPoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CitySearchServiceEndPoint.class);
    }
}
