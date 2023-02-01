package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {
    /**
     * Getter for contact in the contact database by contactID.
     *
     * @param contactID
     * @return contact.
     * @throws SQLException
     * @throws Exception
     */
    public static Contact getContact(int contactID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM contacts WHERE Contact_ID  = '" + contactID + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        Contact contactResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String contactName = result.getString("Contact_Name");
                String email = result.getString("Email");
                contactResult = new Contact(contactID, contactName, email);
                return contactResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Getter for all contacts in the contact database.
     *
     * @return ObservableList of all contacts.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Contact> getAllContacts() throws SQLException, Exception{
        JDBC.openConnection();
        ObservableList<Contact> allContacts = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM contacts";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int contactID = result.getInt("Contact_ID");
                String contactName = result.getString("Contact_Name");
                String Email = result.getString("Email");
                Contact contactResult = new Contact(contactID, contactName, Email);
                allContacts.add(contactResult);
                JDBC.closeConnection();
            }
            return allContacts;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Method that inserts a contact by contactID, contactName, and email.
     *
     * @param contactID
     * @param contactName
     * @param email
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertContact(int contactID, String contactName, String email) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "INSERT INTO contacts (Contact_ID, Contact_Name, Email) VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, contactID);
            preparedStatement.setString(2, contactName);
            preparedStatement.setString(3, email);
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
     * Method that updates a contact by contactName and email.
     *
     * @param contactName
     * @param email
     * @param contactID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateCustomer(String contactName, String email, int contactID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "UPDATE customers SET Contact_Name = ? AND SET Email = ? WHERE Contact_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, contactName);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, contactID);
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
     * Method that deletes a contact in the contact database by contactID.
     *
     * @param contactID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteUser(int contactID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "DELETE FROM contact WHERE Contact_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, contactID);
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
