package com.pythonteam.dao;

import com.pythonteam.models.Teacher;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface TeacherDao {
    @SqlQuery("SELECT * FROM teacher")
    @RegisterBeanMapper(Teacher.class)
    ArrayList<Teacher> list();

    @SqlQuery("SELECT * FROM teacher where :id = id")
    @RegisterBeanMapper(Teacher.class)
    Teacher findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO teacher(name) VALUES (:name);")
    boolean create(@Bind("name") String name);

    @SqlUpdate("delete from teacher where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update teacher set name = :name where id = :id")
    @RegisterBeanMapper(Teacher.class)
    Teacher update(@Bind("id") int id, @Bind("name") String name);


}
