package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.schedulingdesktopapplication.DAO.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User getUser(String userName) throws SQLException, Exception{
        try {
            JDBC.openConnection();
            String sqlStatement = "SELECT * FROM users WHERE User_Name  = '" + userName + "'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            User userResult;
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int userID = result.getInt("User_ID");
                userName = result.getString("User_Name");
                String password = result.getString("Password");
                userResult = new User(userID, userName, password);
                return userResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    public static ObservableList<User> getAllUsers() throws SQLException, Exception{
        try {
            JDBC.openConnection();
            ObservableList<User> allUsers = FXCollections.observableArrayList();
            String sqlStatement = "SELECT * FROM users";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int userID=result.getInt("User_ID");
                String userNameG=result.getString("User_Name");
                String password=result.getString("Password");
                User userResult= new User(userID, userNameG, password);
                allUsers.add(userResult);
                JDBC.closeConnection();
                return allUsers;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    public static User validateUser(String userName, String password) throws SQLException, Exception{
        try
        {
            JDBC.openConnection();
            String sqlStatement = "SELECT * FROM users WHERE User_Name = '" + userName + "' AND User_Password = '" + password +"'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int userID=result.getInt("User_ID");
                userName=result.getString("User_Name");
                password=result.getString("Password");
                User userResult= new User(userID, userName, password);
                return userResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.closeConnection();
        return null;
    }

    public static int insertUser(int userID, String userName, String password) throws SQLException, Exception{
        try {
            JDBC.openConnection();
            String sqlStatement = "INSERT INTO USERS (User_ID, User_Name, Password) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.closeConnection();
        return -1;
    }

    public static int updateUser(int userID, String userName, String password) throws SQLException, Exception{
        try {
            JDBC.openConnection();
            String sqlStatement = "UPDATE USERS SET User_Name = ? AND SET Password = ? WHERE User_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.closeConnection();
        return -1;
    }

    public static int deleteUser(int userID) throws SQLException, Exception{
        try {
            JDBC.openConnection();
            String sqlStatement = "DELETE FROM USERS WHERE User_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, userID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.closeConnection();
        return -1;
    }

}
