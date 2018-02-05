package com.pythonteam.databases;

import java.sql.SQLException;
import java.util.List;

public interface BaseHandler<T> {

    List<T> findAll() throws SQLException;
}
