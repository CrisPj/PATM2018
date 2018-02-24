package com.pythonteam.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

interface BaseHandler<T> {

    List<T> findAll() throws SQLException;
    T findOne(int id) throws SQLException;
    boolean delete(int id) throws SQLException;
    T update(T t) throws SQLException;
    boolean create(T t) throws SQLException;
    T fill(ResultSet rs) throws SQLException;
}
