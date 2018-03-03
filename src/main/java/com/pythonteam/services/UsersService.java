package com.pythonteam.services;

import com.pythonteam.databases.UserHandler;
import com.pythonteam.models.User;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/users")
public class UsersService implements ServiceInterface<User> {

    @TokenSecured
    @Override
    public Response readAll() {
        try {
            return  Response.ok(new UserHandler().findAll(), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response create(User user) {
        try {
            return  Response.ok(new UserHandler().create(user), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @TokenSecured
    @Override
    public Response read(int id) {
        try {
            User user = new UserHandler().findOne(id);
            if (user == null)
                return Response.status(Response.Status.NOT_FOUND).build();
            return Response.ok(new UserHandler().findOne(id), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response update(User user){
        try {
            return  Response.ok(new UserHandler().update(user), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        try {
            return  Response.ok(new UserHandler().delete(id), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
