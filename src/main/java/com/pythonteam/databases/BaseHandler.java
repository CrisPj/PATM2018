package com.pythonteam.databases;

import java.sql.SQLException;
import java.util.List;

public interface BaseHandler<T> {

    List<T> findAll() throws SQLException;
    T findOne(int id) throws SQLException;
    boolean delete(int id) throws SQLException;
    T update(T t) throws SQLException;
    boolean create(T t) throws SQLException;
}
