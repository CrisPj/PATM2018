package com.pythonteam.databases;

import com.pythonteam.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler implements BaseHandler<Employee> {
    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            ResultSet rs = nps.executeQuery();

            while (rs.next()) {

                employees.add(fill(rs));
            }
        }
        return employees;
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

    @Override
    public Employee fill(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setPaternalName(rs.getString("paternalName"));
        employee.setMaternalName(rs.getString("maternalName"));
        employee.setBirthday(rs.getDate("birthday"));
        employee.setEmail(rs.getString("email"));
        employee.setJobId(rs.getInt("jobId"));
        employee.setUserId(rs.getInt("userId"));
        return employee;
    }
}
