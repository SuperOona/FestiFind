package setUp;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restserices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("festi.webservices", "festi/authentication");
        register(RolesAllowedDynamicFeature.class);
    }
}
