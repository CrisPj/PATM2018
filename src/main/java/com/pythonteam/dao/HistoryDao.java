package com.pythonteam.dao;

import com.pythonteam.models.History;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface HistoryDao {
    @SqlQuery("SELECT * FROM history")
    @RegisterBeanMapper(History.class)
    ArrayList<History> list();

    @SqlQuery("SELECT * FROM history where :idCourse = :idCourse and idEmpleado = :idEmpleado")
    @RegisterBeanMapper(History.class)
    History findOne(@Bind("idCourse") int idCourse, @Bind("idEmpleado") int idEmpleado);

    @SqlUpdate("INSERT INTO history(idCourse, idEmpleado, grade) VALUES (:idCourse, :idEmpleado, :grade);")
    boolean create(@Bind("idCourse") int idCourse, @Bind("idEmpleado") int idEmpleado, @Bind("grade") int grade);

    @SqlUpdate("delete from history where idCourse = :idCourse and idEmpleado = :idEmpleado")
    boolean delete(@Bind("idCourse") int idCourse, @Bind("idEmpleado") int idEmpleado);

    @SqlQuery("update history set grade = :grade where idCourse = :idCourse, idEmpleado = :idEmpleado")
    @RegisterBeanMapper(History.class)
    History update(@Bind("idCourse") int idCourse, @Bind("idEmpleado") int idEmpleado, @Bind("grade") int grade);

}
