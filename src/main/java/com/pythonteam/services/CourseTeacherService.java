package com.pythonteam.services;

import com.pythonteam.databases.CourseTeacherHandler;
import com.pythonteam.filters.TokenSecured;
import com.pythonteam.models.CourseTeacher;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/courseTeachers")
public class CourseTeacherService implements ServiceInterface<CourseTeacher> {

    @TokenSecured
    @Override
    public Response readAll() {
        return  Response.ok(new CourseTeacherHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(CourseTeacher courseTeacher) {
        boolean response = new CourseTeacherHandler().create(courseTeacher);
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
    @Path("/{id}")
    public Response read(@QueryParam("id") int id,@QueryParam("id2") int id2) {
        CourseTeacher courseTeacher = new CourseTeacherHandler().findOne(id,id2);
        if (courseTeacher == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(courseTeacher, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(CourseTeacher courseTeacher){
        return  Response.ok(new CourseTeacherHandler().update(courseTeacher), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        boolean response = new CourseTeacherHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
