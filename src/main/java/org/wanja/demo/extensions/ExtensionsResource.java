package org.wanja.demo.extensions;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/extension")
public class ExtensionsResource {

    @Inject
    @RestClient
    ExtensionsService extensionsService;


    @GET
    @Path("/id/{id}")
    public Set<Extension> id(String id) {
        return extensionsService.getById(Integer.valueOf(id));
    }
}