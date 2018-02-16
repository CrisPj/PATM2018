package com.pythonteam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pythonteam.databases.EmployeeHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/employees")
public class EmployeesService implements ServiceInterface {
    @Override
    public Response create() {
        return null;
    }

    @Override
    public Response read() {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response readAll() {
        try {
            return  Response.ok(new ObjectMapper().writeValueAsString(new EmployeeHandler().findAll()), MediaType.APPLICATION_JSON).build();
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
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
