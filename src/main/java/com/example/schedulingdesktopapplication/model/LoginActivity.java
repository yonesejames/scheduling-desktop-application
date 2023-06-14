package com.example.schedulingdesktopapplication.model;
import com.example.schedulingdesktopapplication.DAO.JDBC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * Model class for logged user information.
 *
 * @author Yonese James
 */
public class LoginActivity {
    private static User user;
    private static Locale locale = Locale.getDefault();
    private static ZoneId zoneId = ZoneId.systemDefault();
    private static final String loginActivityPath = "login_activity.txt";

    public static int isUserLoggedIn(String username, String password) throws SQLException {
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM users WHERE User_Name =" + username + " AND " +
                "Password =" + password;
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
            }
            user = new User(result.getInt("User_ID"), result.getString("User_Name"));
            locale = Locale.getDefault();
            zoneId = ZoneId.systemDefault();
            JDBC.closeConnection();
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void getUserActivity(String userName, Boolean successful) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(loginActivityPath, true));
            bufferedWriter.append("USERNAME: " + userName +" | DATE AND TIME: " + ZonedDateTime.now(ZoneOffset.UTC).toString() +
                    " | LOGIN " + (successful ? "SUCCESSFUL" : "UNSUCCESSFUL") + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for the user.
     *
     * @return the user.
     */
    public static User getUser() {
        return user;
    }

    /**
     * Getter for the locale.
     *
     * @return the locale.
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * Getter for the zoneId.
     *
     * @return the zoneId.
     */
    public static ZoneId getZoneId() {
        return zoneId;
    }


}