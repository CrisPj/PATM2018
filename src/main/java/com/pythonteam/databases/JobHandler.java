package com.pythonteam.databases;

import com.pythonteam.models.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobHandler implements BaseHandler<Job>  {
    @Override
    public List<Job> findAll() throws SQLException {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM job";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            ResultSet rs = nps.executeQuery();

            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setJob(rs.getString("job"));
                jobs.add(job);
            }
        }
        return jobs;
    }

    @Override
    public Job findOne(int id) throws SQLException {
        String sql = "select * from job where id = '"+id+"';";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            ResultSet rs = nps.executeQuery();
            if (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setJob(rs.getString("job"));
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return true;
    }

    @Override
    public Job update(Job job) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Job job) throws SQLException {
        return true;
    }
}
