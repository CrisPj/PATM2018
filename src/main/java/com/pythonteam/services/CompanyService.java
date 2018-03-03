package com.pythonteam.services;

import com.pythonteam.databases.CompanyHandler;
import com.pythonteam.filters.TokenSecured;
import com.pythonteam.models.Company;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/companies")
public class CompanyService implements ServiceInterface<Company> {

    @Override
    public Response readAll() {
        return  Response.ok(new CompanyHandler().findAll(), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response create(Company company) {
        boolean response = new CompanyHandler().create(company);
        if (response)
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @TokenSecured
    @Override
    public Response read(int id) {
        Company company = new CompanyHandler().findOne(id);
        if (company == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(company, MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response update(Company company){
        return  Response.ok(new CompanyHandler().update(company), MediaType.APPLICATION_JSON).build();
    }

    @TokenSecured
    @Override
    public Response delete(int id) {
        boolean response = new CompanyHandler().delete(id);
        if (response){
            return  Response.ok(true, MediaType.APPLICATION_JSON).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
