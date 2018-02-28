package com.pythonteam.databases;

import com.pythonteam.models.User;

import javax.inject.Named;
import javax.naming.Name;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                users.add(fill(rs));
            }
            rs.close();
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
                User a = fill(rs);
                rs.close();
                return a;
            }
        }
        return null;
    }



    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from user where id = :id";
        try (Connection conn = Database.getConnection()) {
            NamedParameterStatement nps = new NamedParameterStatement(conn,sql);
            nps.setInt("id",id);
            nps.executeQuery();
        }
        return true;
    }

    @Override
    public User update(User user) throws SQLException {
        String sql = "update user set username = :username, password = :password where id = :id";
        try (Connection conn = Database.getConnection()) {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("username",user.getUsername());
            nps.setString("password",user.getPassword());
            nps.setInt("id",user.getId());
        }
        return user;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = "INSERT INTO user(username, password) VALUES (:user,:password);";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("user", user.getUsername());
            nps.setString("password", user.getPassword());
            nps.executeQuery();
        }
        return true;
    }

    @Override
    public User fill(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    public User checkPass(User user) throws SQLException {
        String sql = "select user where username = :username, password = :password";
        try (Connection conn = Database.getConnection()) {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("username",user.getUsername());
            nps.setString("password",user.getPassword());
        }
        return user;
    }
}
