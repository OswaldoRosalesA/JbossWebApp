package webapps.jbosswebapp.app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.jboss.resteasy.wadl.ResteasyWadlDefaultResource;
import webapps.jbosswebapp.ExampleWS;

public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<>();
        resources.add(ResteasyWadlDefaultResource.class);
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        singletons.add(new ExampleWS());
        return singletons;
    }

}
