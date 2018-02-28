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
    public Response create(Job job) {
        return null;
    }

    @Override
    public Response read(int id) {
        return null;
    }

    @Override
    public Response readAll() {
        try {
            return  Response.ok(new JobHandler().findAll(), MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

//    @Override
//    public Response update(Job job) {
//        return null;
//    }

   /* @Override
    public Response delete(Job job) {
        return null;
    }
*/
}
