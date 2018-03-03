package com.pythonteam.databases;

import com.pythonteam.dao.JobDao;
import com.pythonteam.models.Job;

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
        return Database.getJdbi().withExtension(JobDao.class,dao -> dao.delete(id));
    }

    @Override
    public Job update(Job job) {
        return Database.getJdbi().withExtension(JobDao.class, dao -> dao.update(job.getId(),job.getJob()));
    }

    @Override
    public boolean create(Job job) {
        return Database.getJdbi().withExtension(JobDao.class, dao -> dao.create(job.getJob()));
    }

}
