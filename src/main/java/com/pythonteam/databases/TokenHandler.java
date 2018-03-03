package com.pythonteam.databases;

import com.pythonteam.models.Token;
import com.pythonteam.models.User;
import com.pythonteam.util.Hash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TokenHandler implements BaseHandler<Token>{
    @Override
    public List<Token> findAll() {
        return null;
    }

    @Override
    public Token findOne(int id) throws SQLException {
        return null;
    }

    public Token findOne(String token) throws SQLException {
        String sql = "select * from token where token = :token";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("token",token);
            ResultSet rs = nps.executeQuery();
            if (rs.next()) {
                Token t = fill(rs);
                rs.close();
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Token update(Token token) {
        return null;
    }

    @Override
    public boolean create(Token token) throws SQLException {
        return false;
    }

    public String create(User user) throws SQLException {
        new UserHandler().checkPass(user);
        String sql = "INSERT INTO token(token) VALUES (:token);";
        String tokenHash = new Hash().encriptar(user.getUsername(),user.getPassword());
        try (Connection conn = Database.getConnection()) {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("token", tokenHash);
            nps.executeQuery();
        }
        return "{\"token\": \""+ tokenHash + "\"}";
    }

    @Override
    public Token fill(ResultSet rs) throws SQLException {
        return null;
    }
}
