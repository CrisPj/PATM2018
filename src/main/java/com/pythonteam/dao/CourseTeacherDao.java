package com.pythonteam.dao;

import com.pythonteam.models.CourseTeacher;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Date;
import java.util.ArrayList;

public interface CourseTeacherDao {
    @SqlQuery("SELECT * FROM courseTeacher")
    @RegisterBeanMapper(CourseTeacher.class)
    ArrayList<CourseTeacher> list();

    @SqlQuery("SELECT * FROM courseTeacher where idCourse = :idCourse and idTeacher = :idTeacher")
    @RegisterBeanMapper(CourseTeacher.class)
    CourseTeacher findOne(@Bind("idCourse") int idCourse,@Bind("idTeacher") int id);

    @SqlQuery("SELECT * FROM courseTeacher where idCourse = :idCourse")
    @RegisterBeanMapper(CourseTeacher.class)
    CourseTeacher findOneByCourse(@Bind("idCourse") int id);

    @SqlQuery("SELECT * FROM courseTeacher where idTeacher = :idTeacher")
    @RegisterBeanMapper(CourseTeacher.class)
    CourseTeacher findOneByTeacher(@Bind("idTeacher") int id);

    @SqlUpdate("INSERT INTO courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (:idCourse, :idTeacher, :startDate, :endDate);")
    boolean create(@Bind("idCourse") int idCourse, @Bind("idTeacher") int idteacher, @Bind("startDate") Date startDate, @Bind("endDate") Date endDate);

    @SqlUpdate("delete from courseTeacher where idCourse = :idCourse and idTeacher = :idTeacher")
    boolean delete(@Bind("idCourse") int idCourse,  @Bind("idTeacher") int idTeacher);

    @SqlQuery("update courseTeacher set startDate = :startDate, endDate = :endDate where idCourse = :idCourse and idTeacher = :idTeacher")
    @RegisterBeanMapper(CourseTeacher.class)
    CourseTeacher update(@Bind("idCourse") int idCourse, @Bind("idTeacher") int idteacher, @Bind("startDate") Date startDate, @Bind("endDate") Date endDate);


}
