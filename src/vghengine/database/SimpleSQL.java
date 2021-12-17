/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class SimpleSQL {
    private Connection connection;
    private String url;
    private Statement statement;
    private ResultSet resultSet;
    
    public SimpleSQL(String url, String userName, String password) throws SQLException, ClassNotFoundException {
        setUrl(url);
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, userName, password);
        statement = connection.createStatement();
    }
    
    public SimpleSQL(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);
            statement = connection.createStatement();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    public void insert(String query) throws Exception {
        statement.execute(query);
    }
    
    public ResultSet select(String tableName) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM "+tableName);
            return resultSet;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet selectWhere(String query) {
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update(String tableName, String oldField, String newField) {
        try {
            statement.execute("UPDATE "+tableName+" SET "+newField+" WHERE "+oldField+"");
            System.out.println("UPDATE avvenuto correttamente!");
        }
        catch(SQLException sqle) {
            System.out.println("Errore nell'effettuare l'UPDATE!");
            sqle.printStackTrace();
        }
    }
    
    public void delete(String query) {
        try {
            statement.execute(query);
            System.out.println("DELETE avvenuto correttamente!");
        }
        catch(SQLException sqle) {
            System.out.println("Errore nell'effttuare il DELETE");
            sqle.printStackTrace();
        }
    }
    
}
