package com.pythonteam.databases;

import com.pythonteam.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHandler implements BaseHandler<User> {
    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection conn = Database.getConnection())
        {
             NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
             ResultSet rs = nps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User findOne(int id) throws SQLException {
        String sql = "select * from user where id = :id";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setInt("id",id);
            ResultSet rs = nps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return true;
    }

    @Override
    public User update(User user) throws SQLException {
        return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        return true;
    }

}
