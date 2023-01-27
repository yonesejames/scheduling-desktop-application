package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.schedulingdesktopapplication.DAO.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * DAO class to access the appointment database.
 *
 * @author Yonese James
 */
public class AppointmentDAO {

    /**
     * Getter for appointment in the appointment database by appointmentID.
     *
     * @param appointmentID
     * @return appointment.
     * @throws SQLException
     * @throws Exception
     */
    public static Appointment getAppointment(int appointmentID) throws SQLException, Exception{
        try {
            JDBC.openConnection();
            String sqlStatement = "SELECT * FROM appointments WHERE Appointment_ID  = '" + appointmentID + "'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
            Appointment appointmentResult;
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                appointmentID = result.getInt("Appointment_ID");
                String appointmentTitle = result.getString("Title");
                String appointmentDescription = result.getString("Description");
                String appointmentLocation = result.getString("Location");
                String appointmentType = result.getString("Type");
                Timestamp start = result.getTimestamp("Start");
                Timestamp end = result.getTimestamp("End");
                int customerID = result.getInt("Customer_ID");
                int userID = result.getInt("User_ID");
                int contactID = result.getInt("Contact_ID");
                appointmentResult = new Appointment(appointmentID, appointmentTitle, appointmentDescription,
                        appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                return appointmentResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Getter for all appointments in the appointment database.
     *
     * @return ObservableList of all appointments.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointment> getAllAppointments() throws SQLException, Exception{
        JDBC.openConnection();
        ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int appointmentID = result.getInt("Appointment_ID");
                String appointmentTitle = result.getString("Title");
                String appointmentDescription = result.getString("Description");
                String appointmentLocation = result.getString("Location");
                String appointmentType = result.getString("Type");
                Timestamp start = result.getTimestamp("Start");
                Timestamp end = result.getTimestamp("End");
                int customerID = result.getInt("Customer_ID");
                int userID = result.getInt("User_ID");
                int contactID = result.getInt("Contact_ID");
                Appointment appointment = new Appointment(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                allAppointments.add(appointment);
            }
            return allAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return allAppointments;
    }

    public static ObservableList<Appointment> getWeeklyAppointments() throws SQLException, Exception {
        JDBC.openConnection();
        ObservableList<Appointment> weeklyAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments WHERE Start BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 7 DAY)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();
        try {

            while(result.next()){
                int appointmentID = result.getInt("Appointment_ID");
                String appointmentTitle = result.getString("Title");
                String appointmentDescription = result.getString("Description");
                String appointmentLocation = result.getString("Location");
                String appointmentType = result.getString("Type");
                Timestamp start = result.getTimestamp("Start");
                Timestamp end = result.getTimestamp("End");
                int customerID = result.getInt("Customer_ID");
                int userID = result.getInt("User_ID");
                int contactID = result.getInt("Contact_ID");
                Appointment appointment = new Appointment(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                weeklyAppointments.add(appointment);
            }
            return weeklyAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return weeklyAppointments;
    }

    public static ObservableList<Appointment> getMonthlyAppointments() throws SQLException, Exception {
        JDBC.openConnection();
        ObservableList<Appointment> monthlyAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments WHERE Start BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();
        try {
            while(result.next()){
                int appointmentID = result.getInt("Appointment_ID");
                String appointmentTitle = result.getString("Title");
                String appointmentDescription = result.getString("Description");
                String appointmentLocation = result.getString("Location");
                String appointmentType = result.getString("Type");
                Timestamp start = result.getTimestamp("Start");
                Timestamp end = result.getTimestamp("End");
                int customerID = result.getInt("Customer_ID");
                int userID = result.getInt("User_ID");
                int contactID = result.getInt("Contact_ID");
                Appointment appointment = new Appointment(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                monthlyAppointments.add(appointment);
            }
            return monthlyAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return monthlyAppointments;
    }

    public static int insertAppointment(int userID, String userName, String password) throws SQLException, Exception{
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

    public static int updateAppointment(int userID, String userName, String password) throws SQLException, Exception{
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

    public static int deleteAppointment(int userID) throws SQLException, Exception{
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
