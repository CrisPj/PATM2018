package com.pythonteam.services;

import com.pythonteam.databases.JobHandler;
import com.pythonteam.models.Job;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/jobs")
public class JobsService implements ServiceInterface<Job> {

    

    @Override
    public Response readAll() {
        try {
            return  Response.ok(new JobHandler().findAll(), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response create(Job Job) {
        try {
            return  Response.ok(new JobHandler().create(Job), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @TokenSecured
    @Override
    public Response read(int id) {
        try {
            Job Job = new JobHandler().findOne(id);
            if (Job == null)
                return Response.status(Response.Status.NOT_FOUND).build();
            return Response.ok(new JobHandler().findOne(id), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response update(Job Job){
        try {
            return  Response.ok(new JobHandler().update(Job), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        try {
            return  Response.ok(new JobHandler().delete(id), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
