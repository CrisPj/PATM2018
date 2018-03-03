package com.pythonteam.databases;

import com.pythonteam.dao.EmployeeDao;
import com.pythonteam.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler implements BaseHandler<Employee> {
    @Override
    public List<Employee> findAll() {
        return Database.getJdbi().withExtension(EmployeeDao.class, EmployeeDao::list);
    }

    @Override
    public Employee findOne(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean create(Employee employee) {
        return true;
    }
    }
