package com.pythonteam.databases;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NamedParameterStatement
{
    private final PreparedStatement statement;

    private final Map indexMap;

    NamedParameterStatement(Connection connection, String query) throws
            SQLException {
        indexMap=new HashMap();
        String parsedQuery=parse(query, indexMap);
        statement=connection.prepareStatement(parsedQuery);
    }

    private static String parse(String query, Map paramMap) {
        int length=query.length();
        StringBuilder parsedQuery=new StringBuilder(length);
        boolean inSingleQuote=false;
        boolean inDoubleQuote=false;
        int index=1;

        for(int i=0;i<length;i++) {
            char c=query.charAt(i);
            if(inSingleQuote) {
                if(c=='\'') {
                    inSingleQuote=false;
                }
            } else if(inDoubleQuote) {
                if(c=='"') {
                    inDoubleQuote=false;
                }
            } else {
                if(c=='\'') {
                    inSingleQuote=true;
                } else if(c=='"') {
                    inDoubleQuote=true;
                } else if(c==':' && i+1<length &&
                        Character.isJavaIdentifierStart(query.charAt(i+1))) {
                    int j=i+2;
                    while(j<length && Character.isJavaIdentifierPart(query.charAt(j))) {
                        j++;
                    }
                    String name=query.substring(i+1,j);
                    c='?'; // replace the parameter with a question mark
                    i+=name.length(); // skip past the end if the parameter

                    List indexList=(List)paramMap.get(name);
                    if(indexList==null) {
                        indexList=new LinkedList();
                        paramMap.put(name, indexList);
                    }
                    indexList.add(index);

                    index++;
                }
            }
            parsedQuery.append(c);
        }

        // replace the lists of Integer objects with arrays of ints
        for (Object o : paramMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            List list = (List) entry.getValue();
            int[] indexes = new int[list.size()];
            int i = 0;
            for (Object aList : list) {
                Integer x = (Integer) aList;
                indexes[i++] = x;
            }
            entry.setValue(indexes);
        }

        return parsedQuery.toString();
    }

    private int[] getIndexes(String name) {
        int[] indexes=(int[])indexMap.get(name);
        if(indexes==null) {
            throw new IllegalArgumentException("Parameter not found: "+name);
        }
        return indexes;
    }

    public void setObject(String name, Object value) throws SQLException {
        int[] indexes=getIndexes(name);
        for (int indexe : indexes) {
            statement.setObject(indexe, value);
        }
    }

    public void setString(String name, String value) throws SQLException {
        int[] indexes=getIndexes(name);
        for (int indexe : indexes) {
            statement.setString(indexe, value);
        }
    }

    public void setInt(String name, int value) throws SQLException {
        int[] indexes=getIndexes(name);
        for (int indexe : indexes) {
            statement.setInt(indexe, value);
        }
    }

    public void setLong(String name, long value) throws SQLException {
        int[] indexes=getIndexes(name);
        for (int indexe : indexes) {
            statement.setLong(indexe, value);
        }
    }

    public void setTimestamp(String name, Timestamp value) throws SQLException
    {
        int[] indexes=getIndexes(name);
        for (int indexe : indexes) {
            statement.setTimestamp(indexe, value);
        }
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public boolean execute() throws SQLException {
        return statement.execute();
    }

    public ResultSet executeQuery() throws SQLException {
        return statement.executeQuery();
    }


    public int executeUpdate() throws SQLException {
        return statement.executeUpdate();
    }

    public void close() throws SQLException {
        statement.close();
    }

    public void addBatch() throws SQLException {
        statement.addBatch();
    }

    public int[] executeBatch() throws SQLException {
        return statement.executeBatch();
    }
}