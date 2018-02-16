package com.pythonteam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pythonteam.databases.UserHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/users")
public class UsersService implements ServiceInterface {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response readAll() {
        try {
            return  Response.ok(new ObjectMapper().writeValueAsString(new UserHandler().findAll()), MediaType.APPLICATION_JSON).build();
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Override
    public Response create() {
        return null;
    }

    @Override
    public Response read() {
        return null;
    }

    @Override
    public Response update() {
        return null;
    }

    @Override
    public Response delete() {
        return null;
    }
}
