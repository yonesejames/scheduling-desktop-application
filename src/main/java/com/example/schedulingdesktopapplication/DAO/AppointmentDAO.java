package com.example.schedulingdesktopapplication.DAO;
import com.example.schedulingdesktopapplication.controller.LoginScreenController;
import com.example.schedulingdesktopapplication.model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

/**
 * DAO class to access the appointment database.
 *
 * @author Yonese James
 */
public class AppointmentDAO {
    /**
     * Getter for all appointments in the appointment database.
     *
     * @return ObservableList of all appointments.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointment> getAllAppointments() throws SQLException, Exception{
        ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments as appointment LEFT OUTER JOIN contacts as contact " +
                "ON appointment.Contact_ID = contact.Contact_ID;";
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
                String contactName = result.getString("Contact_Name");
                Appointment appointment = new Appointment(appointmentID, appointmentTitle, appointmentDescription,
                        appointmentLocation, appointmentType, start, end, customerID, userID, contactID,contactName);
                allAppointments.add(appointment);
            }
            return allAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for weekly appointments in the appointment database.
     *
     * @return ObservableList of all appointments.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointment> getWeeklyAppointments() throws SQLException, Exception {
        ObservableList<Appointment> weeklyAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments WHERE Start BETWEEN now() - INTERVAL 7 day AND now()";
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
        return null;
    }

    /**
     * Getter for monthly appointments in the appointment database.
     *
     * @return ObservableList of all appointments.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointment> getMonthlyAppointments() throws SQLException, Exception {
        ObservableList<Appointment> monthlyAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM appointments WHERE Start BETWEEN now() - INTERVAL 30 day AND now()";
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
                Appointment appointment = new Appointment(appointmentID, appointmentTitle, appointmentDescription,
                        appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                monthlyAppointments.add(appointment);
            }
            return monthlyAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method that inserts an appointment by appointmentID, title, description, location, type, startDateTime,
     * endDateTime, createDate, createdBy, lastUpdate, lastUpdatedBy, customerID, userID, and contactID.
     *
     * @param title
     * @param description
     * @param location
     * @param type
     * @param startDateTime
     * @param endDateTime
     * @param createdBy
     * @param lastUpdatedBy
     * @param customerID
     * @param userID
     * @param contactID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertAppointment(String title, String description, String location,
                                        String type, Timestamp startDateTime, Timestamp endDateTime,
                                        String createdBy, String lastUpdatedBy, int customerID,
                                        int userID, int contactID) throws SQLException, Exception{
        String sqlStatement = "INSERT INTO appointments (Title, Description, Location, Type, Start, End, " +
                "Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID) " +
                "VALUES(?, ?, ?, ?, ?, ?, now(), ?, now(), ?, ?, ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, type);
            preparedStatement.setTimestamp(5, startDateTime);
            preparedStatement.setTimestamp(6, endDateTime);
            preparedStatement.setString(7, createdBy);
            preparedStatement.setString(8, lastUpdatedBy);
            preparedStatement.setInt(9, customerID);
            preparedStatement.setInt(10, userID);
            preparedStatement.setInt(11, contactID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Method that updates an appointment by title, description, location, type, startDateTime,
     * endDateTime, createDate, createdBy, lastUpdate, lastUpdatedBy, customerID, userID, and contactID.
     *
     * @param title
     * @param description
     * @param location
     * @param type
     * @param startDateTime
     * @param endDateTime
     * @param customerID
     * @param userID
     * @param contactID
     * @param appointmentID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateAppointment(String title, String description, String location,
                                        String type, Timestamp startDateTime, Timestamp endDateTime, int customerID,
                                        int userID, int contactID, int appointmentID) throws SQLException, Exception{
        String sqlStatement = "UPDATE appointments SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, " +
                "Last_Update = now(), Last_Updated_By = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        String lastUpdatedBy = String.valueOf(LoginScreenController.username);

        try {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, type);
            preparedStatement.setTimestamp(5, startDateTime);
            preparedStatement.setTimestamp(6, endDateTime);
            preparedStatement.setString(7, lastUpdatedBy);
            preparedStatement.setInt(8, customerID);
            preparedStatement.setInt(9, userID);
            preparedStatement.setInt(10, contactID);
            preparedStatement.setInt(11, appointmentID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Method that deletes an appointment in the appointment database by appointmentID.
     *
     * @param appointmentID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteAppointment(int appointmentID) throws SQLException, Exception{
        String sqlStatement = "DELETE FROM appointments WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        try {
            preparedStatement.setInt(1, appointmentID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

//    /**
//     * Getter for appointment in the appointment database by appointmentID.
//     *
//     * @param appointmentID
//     * @return appointment.
//     * @throws SQLException
//     * @throws Exception
//     */
//    public static Appointment getAppointment(int appointmentID) throws SQLException, Exception{
//        try {
//            String sqlStatement = "SELECT * FROM appointments WHERE Appointment_ID  = '" + appointmentID + "'";
//            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
//            Appointment appointmentResult;
//            ResultSet result = preparedStatement.executeQuery();
//
//            while(result.next()){
//                String appointmentTitle = result.getString("Title");
//                String appointmentDescription = result.getString("Description");
//                String appointmentLocation = result.getString("Location");
//                String appointmentType = result.getString("Type");
//                Timestamp start = result.getTimestamp("Start");
//                Timestamp end = result.getTimestamp("End");
//                int customerID = result.getInt("Customer_ID");
//                int userID = result.getInt("User_ID");
//                int contactID = result.getInt("Contact_ID");
//                appointmentResult = new Appointment(appointmentID, appointmentTitle, appointmentDescription,
//                        appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
//                return appointmentResult;
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
