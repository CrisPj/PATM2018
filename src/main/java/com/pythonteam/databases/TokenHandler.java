package com.pythonteam.databases;

import com.pythonteam.models.Token;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TokenHandler implements BaseHandler<Token>{
    @Override
    public List<Token> findAll() {
        return null;
    }

    @Override
    public Token findOne(int id) {
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
    public boolean create(Token token) {
        return true;
    }

    @Override
    public Token fill(ResultSet rs) throws SQLException {
        return null;
    }
}
