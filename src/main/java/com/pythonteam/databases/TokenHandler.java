package com.pythonteam.databases;

import com.pythonteam.models.Token;

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
        String sql = "select * from token where token = :token";
        try (Connection conn = Database.getConnection())
        {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setInt("token",id);
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
        String sql = "INSERT INTO token(token) VALUES (:token);";
        String tokenHash = "asD";
        try (Connection conn = Database.getConnection()) {
            NamedParameterStatement nps = new NamedParameterStatement(conn, sql);
            nps.setString("token", tokenHash);
            nps.executeQuery();
        }
        return true;
    }

    @Override
    public Token fill(ResultSet rs) throws SQLException {
        return null;
    }
}
