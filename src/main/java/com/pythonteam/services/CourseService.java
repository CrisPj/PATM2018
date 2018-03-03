package com.pythonteam.services;

import com.pythonteam.databases.CourseHandler;
import com.pythonteam.filters.TokenSecured;
import com.pythonteam.models.Course;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/courses")
public class CourseService implements ServiceInterface<Course> {

    @TokenSecured
    @Override
    public Response readAll() {
        return  Response.ok(new CourseHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(Course course) {
        boolean response = new CourseHandler().create(course);
        if (response)
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response read(int id) {
        Course course = new CourseHandler().findOne(id);
        if (course == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(course, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(Course course){
        return  Response.ok(new CourseHandler().update(course), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        boolean response = new CourseHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
