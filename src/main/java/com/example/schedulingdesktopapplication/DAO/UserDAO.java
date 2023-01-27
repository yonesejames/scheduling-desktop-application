package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.schedulingdesktopapplication.DAO.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO class to access the user database.
 *
 * @author Yonese James
 */
public class UserDAO {

    /**
     * Getter for user in the user database by userName.
     *
     * @param userName
     * @return user.
     * @throws SQLException
     * @throws Exception
     */
    public static User getUser(String userName) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM users WHERE User_Name  = '" + userName + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        User userResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
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

    /**
     * Getter for all users in the user database.
     *
     * @return ObservableList of all users.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<User> getAllUsers() throws SQLException, Exception{
        JDBC.openConnection();
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM users";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int userID=result.getInt("User_ID");
                String userName=result.getString("User_Name");
                String password=result.getString("Password");
                User userResult= new User(userID, userName, password);
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

    /**
     * Method that validates if the user exists or not.
     * It will return the user if the user exists, but if not then it will return null.
     *
     * @param userName
     * @param password
     * @return user or null.
     * @throws SQLException
     * @throws Exception
     */
    public static Boolean validateUser(String userName, String password) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM users WHERE User_Name = '" + userName + "' AND Password = '" + password +"'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try
        {
            while(result.next()){
                int userID=result.getInt("User_ID");
                userName=result.getString("User_Name");
                password=result.getString("Password");
                User userResult= new User(userID, userName, password);
                return Boolean.TRUE;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.closeConnection();
        return Boolean.FALSE;
    }

    /**
     * Method that inserts a user by userID, userName, and password.
     *
     * @param userID
     * @param userName
     * @param password
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertUser(int userID, String userName, String password) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "INSERT INTO USERS (User_ID, User_Name, Password) VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
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

    /**
     * Method that updates the user in the user database by userID, userName, and password.
     *
     * @param userID
     * @param userName
     * @param password
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateUser(int userID, String userName, String password) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "UPDATE USERS SET User_Name = ? AND SET Password = ? WHERE User_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
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

    /**
     * Method that deletes a user in the user database by userID.
     *
     * @param userID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteUser(int userID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "DELETE FROM USERS WHERE User_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
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
