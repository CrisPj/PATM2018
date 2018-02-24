package com.pythonteam.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


interface ServiceInterface<T> {

    //crud
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(T t);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response read(@PathParam("id") int id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response readAll();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(T t);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response delete(T t);
}
