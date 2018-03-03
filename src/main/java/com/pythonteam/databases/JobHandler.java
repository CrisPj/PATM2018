package com.pythonteam.databases;

import com.pythonteam.dao.JobDao;
import com.pythonteam.models.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobHandler implements BaseHandler<Job>  {
    @Override
    public List<Job> findAll() {
        return Database.getJdbi().withExtension(JobDao.class, JobDao::list);
    }

    @Override
    public Job findOne(int id) {
        return Database.getJdbi().withExtension(JobDao.class, dao -> dao.findOne(id));
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Job update(Job job) {
        return null;
    }

    @Override
    public boolean create(Job job) {
        return true;
    }

}
