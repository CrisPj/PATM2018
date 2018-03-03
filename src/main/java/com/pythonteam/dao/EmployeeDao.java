package com.pythonteam.dao;

import com.pythonteam.models.Employee;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface EmployeeDao {
    @SqlQuery("SELECT * FROM employee")
    @RegisterBeanMapper(Employee.class)
    ArrayList<Employee> list();

    @SqlQuery("SELECT * FROM employee where :id = id")
    @RegisterBeanMapper(Employee.class)
    Employee findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO employee(employeename, password) VALUES (:employee,:password);")
    boolean create(@Bind("employee") String employeename, @Bind("password") String password);

    @SqlUpdate("delete from employee where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update employee set employeename = :employeename, password = :password where id = :id")
    @RegisterBeanMapper(Employee.class)
    Employee update(@Bind("employeename") String employeename, @Bind("password") String password);


}
