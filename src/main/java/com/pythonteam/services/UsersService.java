package com.pythonteam.services;

import com.pythonteam.databases.UserHandler;
import com.pythonteam.models.User;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/users")
public class UsersService implements ServiceInterface<User> {


    @Override
    public Response readAll() {
        try {
            return  Response.ok(new UserHandler().findAll(), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response create(User user) {
        try {
            return  Response.ok(new UserHandler().create(user), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @Override
    public Response read(int id) {
        try {
            return  Response.ok(new UserHandler().findOne(id), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
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
