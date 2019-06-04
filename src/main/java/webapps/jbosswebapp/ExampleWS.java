package webapps.jbosswebapp;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import webapps.jbosswebapp.beans.BasicResponse;
import webapps.jbosswebapp.security.JWTTokenNeeded;

/**
 *
 * @author oswaldo
 */
@Path("/example")
public class ExampleWS {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response index() {
        return Response.ok("ExampleWS").build();
    }

    @POST
    @Path("postexample")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postExample(@NotNull @FormParam("message") String message) {
        return Response.status(Response.Status.OK)
                .entity(new BasicResponse(message))
                .build();
    }

    @POST
    @Path("securePostExample")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response securePostExample(@NotNull @FormParam("message") String message) {
        return Response.status(Response.Status.OK)
                .entity(new BasicResponse(message))
                .build();
    }

}
