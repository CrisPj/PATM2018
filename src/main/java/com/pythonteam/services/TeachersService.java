package com.pythonteam.services;

import com.pythonteam.databases.TeacherHandler;
import com.pythonteam.filters.TokenSecured;
import com.pythonteam.models.Teacher;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teachers")
public class TeachersService implements ServiceInterface<Teacher> {

    @Override
    public Response readAll() {
        return  Response.ok(new TeacherHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(Teacher teacher) {
        boolean response = new TeacherHandler().create(teacher);
        if (response)
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response read(int id) {
        Teacher teacher = new TeacherHandler().findOne(id);
        if (teacher == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(teacher, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(Teacher teacher){
        return  Response.ok(new TeacherHandler().update(teacher), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        boolean response = new TeacherHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
