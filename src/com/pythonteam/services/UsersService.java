package com.pythonteam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pythonteam.databases.UserHandler;
import com.pythonteam.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/users")
public class UsersService implements ServiceInterface<User> {


    @Override
    public Response readAll() {
        try {
            return  Response.ok(new ObjectMapper().writeValueAsString(new UserHandler().findAll()), MediaType.APPLICATION_JSON).build();
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response create(User user) {
        try {
            return  Response.ok(new ObjectMapper().writeValueAsString(new UserHandler().create(user)), MediaType.APPLICATION_JSON).build();
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @Override
    public Response read(int id) {
        try {
            return  Response.ok(new ObjectMapper().writeValueAsString(new UserHandler().findOne(id)), MediaType.APPLICATION_JSON).build();
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id) {
        return null;
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        return null;
    }
}
