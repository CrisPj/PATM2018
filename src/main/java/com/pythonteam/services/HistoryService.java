package com.pythonteam.services;

import com.pythonteam.databases.HistoryHandler;
import com.pythonteam.filters.TokenSecured;
import com.pythonteam.models.History;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/history")
public class HistoryService implements ServiceInterface<History> {

    @TokenSecured
    @Override
    public Response readAll() {
        return  Response.ok(new HistoryHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(History history) {
        boolean response = new HistoryHandler().create(history);
        if (response)
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response read(int id) {
            return null;
    }

    @TokenSecured
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@QueryParam("id") int id,@QueryParam("id2") int id2) {
        History history = new HistoryHandler().findOne(id,id2);
        if (history == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(history, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(History history){
        return  Response.ok(new HistoryHandler().update(history), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @TokenSecured
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") int id,@QueryParam("id2") int id2) {
        boolean response = new HistoryHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
