package com.example.schedulingdesktopapplication.DAO;
import com.example.schedulingdesktopapplication.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * DAO class to access the user database.
 *
 * @author Yonese James
 */
public class UserDAO {

    /**
     * Getter for user in the user database by userName.
     *
     * @param username for user.
     * @return user.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when function does not work correctly.
     */
    public static User getUser(String username) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM users WHERE User_Name  = '" + username + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        User userResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int userID = result.getInt("User_ID");
                String password = result.getString("Password");
                userResult = new User(userID, username, password);
                return userResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for userID in the user database by userName.
     *
     * @param username for user.
     * @return user.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when function does not work correctly.
     */
    public static Integer getUserID(String username) throws SQLException, Exception{
        String sqlStatement = "SELECT User_ID FROM users WHERE User_Name = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        preparedStatement.setString(1, username);
        ResultSet result = preparedStatement.executeQuery();

        try {
            Integer userID = null;
            while (result.next()) {
                userID = result.getInt("User_ID");
            }
            return userID;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for all users in the user database.
     *
     * @return ObservableList of all users.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when function does not work correctly.
     */
    public static ObservableList<User> getAllUsers() throws SQLException, Exception{
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM users";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int userID = result.getInt("User_ID");
                String userName=result.getString("User_Name");
                String password=result.getString("Password");
                User userResult= new User(userID, userName, password);
                allUsers.add(userResult);
                JDBC.closeConnection();
            }
            return allUsers;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method that validates if the user exists or not.
     * It will return the user if the user exists, but if not then it will return null.
     *
     * @param userName for user.
     * @param password for user.
     * @return user or null.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when function does not work correctly.
     */
    public static Boolean validateUser(String userName, String password) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM users WHERE User_Name = '" + userName + "' AND Password = '" + password +"'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try
        {
            while(result.next()){
                int userID = result.getInt("User_ID");
                userName = result.getString("User_Name");
                password = result.getString("Password");
                User userResult= new User(userID, userName, password);
                return Boolean.TRUE;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * Method that inserts a user by userID, userName, and password.
     *
     * @param userID for user.
     * @param userName for user.
     * @param password for user.
     * @return the number of rows affected by this change.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when user does not insert.
     */
    public static int insertUser(int userID, String userName, String password) throws SQLException, Exception{
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
        return -1;
    }

    /**
     * Method that updates the user in the user database by userName, and password.
     *
     * @param userName for user.
     * @param password for user.
     * @param userID for user.
     * @return the number of rows affected by this change.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when user does not update.
     */
    public static int updateUser(String userName, String password, int userID) throws SQLException, Exception{
        String sqlStatement = "UPDATE USERS SET User_Name = ? AND SET Password = ? WHERE User_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, userID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Method that deletes a user in the user database by userID.
     *
     * @param userID for user.
     * @return the number of rows affected by this change.
     * @throws SQLException when SQL does not query correctly.
     * @throws Exception when user does not delete.
     */
    public static int deleteUser(int userID) throws SQLException, Exception{
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
        return -1;
    }

}
