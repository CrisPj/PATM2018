package com.pythonteam.dao;

import com.pythonteam.models.Job;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface JobDao {
    @SqlQuery("SELECT * FROM job")
    @RegisterBeanMapper(Job.class)
    ArrayList<Job> list();

    @SqlQuery("SELECT * FROM job where :id = id")
    @RegisterBeanMapper(Job.class)
    Job findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO job(job) VALUES (:job);")
    boolean create(@Bind("job") String jobname);

    @SqlUpdate("delete from job where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update job set job = :job where id = :id")
    @RegisterBeanMapper(Job.class)
    Job update(@Bind("id") int id, @Bind("job") String job);


}
