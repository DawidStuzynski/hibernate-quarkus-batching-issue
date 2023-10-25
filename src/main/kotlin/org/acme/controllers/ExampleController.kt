package org.acme.controllers

import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.enities.ParentEntity
import org.acme.services.ExampleService

@Path("/hello")
class ExampleController(private val service: ExampleService) {

    @GET
    @Path("/api1")
    @Produces(MediaType.APPLICATION_JSON)
    fun hello1(): Uni<ParentEntity> {
        return service.save()
    }
}