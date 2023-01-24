package com.example.schedulingdesktopapplication.DAO;

import java.sql.Statement;
import java.sql.ResultSet;
import static com.example.schedulingdesktopapplication.DAO.JDBC.connection;

public class Query {
    private static String query;
    private static Statement statement;
    private static ResultSet result;

    public static void makeQuery(String q){
        query =q;
        try{
            statement = connection.createStatement();
            // determine query execution
            if(query.toLowerCase().startsWith("select"))
                result=statement.executeQuery(q);
            if(query.toLowerCase().startsWith("delete")||query.toLowerCase().startsWith("insert")||query.toLowerCase().startsWith("update"))
                statement.executeUpdate(q);
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    public static ResultSet getResult(){
        return result;
    }
}