package com.pythonteam.databases;

import com.pythonteam.models.Token;

import java.sql.SQLException;
import java.util.List;

public class TokenHandler implements BaseHandler<Token>{
    @Override
    public List<Token> findAll() throws SQLException {
        return null;
    }

    @Override
    public Token findOne(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return true;
    }

    @Override
    public Token update(Token token) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Token token) throws SQLException {
        return true;
    }
}
