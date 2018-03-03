package com.pythonteam.dao;

import com.pythonteam.models.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface UserDao {

    @SqlQuery("SELECT * FROM user")
    @RegisterBeanMapper(User.class)
    ArrayList<User> list();

    @SqlQuery("SELECT * FROM user where :id = id")
    @RegisterBeanMapper(User.class)
    User findOne(@Bind("id") int id);

    @SqlUpdate("INSERT INTO user(username, password) VALUES (:user,:password);")
    boolean create(@Bind("user") String username, @Bind("password") String password);

    @SqlUpdate("delete from user where id = :id")
    boolean delete(@Bind("id") int id);

    @SqlQuery("update user set username = :username, password = :password where id = :id")
    @RegisterBeanMapper(User.class)
    User update(@Bind("id") int id, @Bind("username") String username, @Bind("password") String password);


    @SqlQuery("select * from user where username = :username and password = :password")
    @RegisterBeanMapper(User.class)
    User check(@Bind("username") String username, @Bind("password") String password);



}
