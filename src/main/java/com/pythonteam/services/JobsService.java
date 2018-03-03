package com.pythonteam.services;

import com.pythonteam.databases.JobHandler;
import com.pythonteam.models.Job;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jobs")
public class JobsService implements ServiceInterface<Job> {

    @Override
    public Response readAll() {
        return  Response.ok(new JobHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(Job job) {
        boolean response = new JobHandler().create(job);
        if (response)
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response read(int id) {
        Job job = new JobHandler().findOne(id);
        if (job == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(job, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(Job job){
        return  Response.ok(new JobHandler().update(job), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        boolean response = new JobHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
