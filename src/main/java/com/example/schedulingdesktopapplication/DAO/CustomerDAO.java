package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CustomerDAO {
    /**
     * Getter for customer in the customer database by customerID.
     *
     * @param customerID
     * @return customer.
     * @throws SQLException
     * @throws Exception
     */
    public static Customer getCustomer(int customerID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM customers WHERE Customer_ID  = '" + customerID + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        Customer customerResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String customerName = result.getString("Customer_Name");
                String address = result.getString("Address");
                String postalCode = result.getString("Postal_code");
                String phone = result.getString("Phone");
                Timestamp createDate = result.getTimestamp("Create_Date");
                String createdBy = result.getString("Created_By");
                Timestamp lastUpdate = result.getTimestamp("Last_Update");
                String lastUpdatedBy = result.getString("Last_Update_BY");
                int divisionID = result.getInt("Division_ID");
                customerResult = new Customer(customerID, customerName, address, postalCode, phone, createDate,
                        createdBy, lastUpdate, lastUpdatedBy,divisionID);
                return customerResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

//    /**
//     * Getter for division in the customers database by divisionID.
//     *
//     * @param divisionID
//     * @return division.
//     * @throws SQLException
//     * @throws Exception
//     */
//    public static Customer getDivision(int divisionID) throws SQLException, Exception{
//        JDBC.openConnection();
//        String sqlStatement = "SELECT Division FROM customers WHERE Customer_ID  = '" + customerID + "'";
//        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
//        Customer customerResult;
//        ResultSet result = preparedStatement.executeQuery();
//
//        try {
//            while(result.next()){
//                String customerName = result.getString("Customer_Name");
//                String address = result.getString("Address");
//                String postalCode = result.getString("Postal_code");
//                String phone = result.getString("Phone");
//                Timestamp createDate = result.getTimestamp("Create_Date");
//                String createdBy = result.getString("Created_By");
//                Timestamp lastUpdate = result.getTimestamp("Last_Update");
//                String lastUpdatedBy = result.getString("Last_Update_BY");
//                int divisionID = result.getInt("Division_ID");
//                customerResult = new Customer(customerID, customerName, address, postalCode, phone, createDate,
//                        createdBy, lastUpdate, lastUpdatedBy,divisionID);
//                return customerResult;
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        JDBC.closeConnection();
//        return null;
//    }


    /**
     * Getter for all customers in the customers database.
     *
     * @return ObservableList of all customers.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Customer> getAllCustomers() throws SQLException, Exception{
        JDBC.openConnection();
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
//        String sqlStatement = "SELECT * FROM customers";
        String sqlStatement = "SELECT cx.Customer_ID, cx.Customer_Name, cx.Address, cx.Postal_Code, cx.Phone, cx.Division_ID, " +
                "f.Division, f.COUNTRY_ID, co.Country FROM customers as cx INNER JOIN first_level_divisions " +
                "as f on cx.Division_ID = f.Division_ID INNER JOIN countries as co ON f.COUNTRY_ID = co.Country_ID";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int customerID = result.getInt("Customer_ID");
                String customerName = result.getString("Customer_Name");
                String address = result.getString("Address");
                String postalCode = result.getString("Postal_code");
                String phone = result.getString("Phone");
                String  division = result.getString("Division");
//                Timestamp createDate = result.getTimestamp("Create_Date");
//                String createdBy = result.getString("Created_By");
//                Timestamp lastUpdate = result.getTimestamp("Last_Update");
//                String lastUpdatedBy = result.getString("Last_Update_BY");
                int divisionID = result.getInt("Division_ID");
                String country = result.getString("Country");
//                Customer customerResult = new Customer(customerID, customerName, address, postalCode, phone, createDate,
//                        createdBy, lastUpdate, lastUpdatedBy,divisionID);
                Customer customerResult = new Customer(customerID, customerName, address, postalCode, phone, division, divisionID, country);
                allCustomers.add(customerResult);

            }
//            JDBC.closeConnection();
            return allCustomers;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Method that inserts a customer by customerID, customerName, address, postalCode, phone, createDate, createdBy,
     * lastUpdate, lastUpdatedBy, and divisionID.
     *
     * @param customerID
     * @param customerName
     * @param address
     * @param postalCode
     * @param phone
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param divisionID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertCustomer(int customerID, String customerName, String address, String postalCode, String phone,
                                     Timestamp createDate, String createdBy, Timestamp lastUpdate, String lastUpdatedBy,
                                     int divisionID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone," +
                "Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) " +
                "VALUES(?, ?, ?, ?, now(), ?, now(), ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postalCode);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, createdBy);
//            NA for lastUpdatedBy
            preparedStatement.setString(6, lastUpdatedBy);
            preparedStatement.setInt(7, divisionID);
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
     * Method that updates a customer by customerName, address, postalCode, phone, createDate, createdBy,
     * lastUpdate, lastUpdatedBy, and divisionID.
     *
     * @param customerName
     * @param address
     * @param postalCode
     * @param phone
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param divisionID
     * @param customerID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateCustomer(String customerName, String address, String postalCode, String phone,
                                 Timestamp createDate, String createdBy, Timestamp lastUpdate, String lastUpdatedBy,
                                 int divisionID, int customerID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "UPDATE customers SET Customer_Name = ? AND SET Address = ? AND SET Postal_Code = ? " +
                "AND SET Phone = ? AND SET Create_Date = ? AND SET Created_By = ? AND SET Last_Update = ? " +
                "AND SET Last_Updated_By = ? AND SET Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postalCode);
            preparedStatement.setString(4, phone);
            preparedStatement.setTimestamp(5, createDate);
            preparedStatement.setString(6, createdBy);
            preparedStatement.setTimestamp(7, lastUpdate);
            preparedStatement.setString(8, lastUpdatedBy);
            preparedStatement.setInt(9, divisionID);
            preparedStatement.setInt(10, customerID);
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
     * Method that deletes a customer in the customers database by customerID.
     *
     * @param customerID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteCustomer(int customerID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "DELETE FROM customers WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, customerID);
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
