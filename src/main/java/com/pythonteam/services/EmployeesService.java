package com.pythonteam.services;

import com.pythonteam.databases.EmployeeHandler;
import com.pythonteam.models.Employee;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/employees")
public class EmployeesService implements ServiceInterface<Employee> {
    @Override
    public Response create(Employee employee) {
        return null;
    }

    @Override
    public Response read(int id) {
        return null;
    }

    @Override
    public Response readAll() {
            return Response.ok(new EmployeeHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(Employee employee) {
        return null;
    }

    @Override
    public Response delete(int id) {
        return null;
    }

}
