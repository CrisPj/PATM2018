package com.pythonteam.dao;

import com.pythonteam.models.Course;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface CourseDao {
    @SqlQuery("SELECT * FROM course")
    @RegisterBeanMapper(Course.class)
    ArrayList<Course> list();

    @SqlQuery("SELECT * FROM course where :id = id")
    @RegisterBeanMapper(Course.class)
    Course findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO course(course,description,hours) VALUES (:course,:description,:hours);")
    boolean create(@Bind("course") String course, @Bind("description") String description,@Bind("hours") int hours);

    @SqlUpdate("delete from course where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update course set course = :course, description = :description, hours = :hours where id = :id")
    @RegisterBeanMapper(Course.class)
    Course update(@Bind("id") int id, @Bind("course") String course, @Bind("description") String description,@Bind("hours") int hours);

}
