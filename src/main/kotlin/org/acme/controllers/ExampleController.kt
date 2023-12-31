package org.acme.controllers

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.dtos.ParentDto
import org.acme.services.ExampleService

@Path("/hello")
class ExampleController(private val service: ExampleService) {

    @GET
    @Path("/api1")
    @Produces(MediaType.APPLICATION_JSON)
    fun hello1(): ParentDto {
        return service.save()
    }
}