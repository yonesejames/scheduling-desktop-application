package com.example.schedulingdesktopapplication.DAO;
import com.example.schedulingdesktopapplication.controller.LoginScreenController;
import com.example.schedulingdesktopapplication.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    /**
     * Getter for all customers in the customer's database.
     *
     * @return ObservableList of all customers.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Customer> getAllCustomers() throws SQLException, Exception{
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
        String sqlStatement = "SELECT customer.Customer_ID, customer.Customer_Name, customer.Address, customer.Postal_Code, customer.Phone, customer.Division_ID, " +
                "division.Division, division.COUNTRY_ID, country.Country FROM customers as customer INNER JOIN first_level_divisions " +
                "as division on customer.Division_ID = division.Division_ID INNER JOIN countries as country ON division.COUNTRY_ID = country.Country_ID";
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
                int divisionID = result.getInt("Division_ID");
                String country = result.getString("Country");

                Customer customerResult = new Customer(customerID, customerName, address, postalCode, phone, division, divisionID, country);
                allCustomers.add(customerResult);
            }
            return allCustomers;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for all customer IDs in the customer's database.
     *
     * @return ObservableList of all customer IDs.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Integer> getCustomerIDs() throws SQLException, Exception{
        ObservableList<Integer> allCustomers = FXCollections.observableArrayList();
        String sqlStatement = "SELECT DISTINCT Customer_ID FROM customers";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int customerID = result.getInt("Customer_ID");
                allCustomers.add(customerID);
            }
            return allCustomers;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method that inserts a customer by customerID, customerName, address, postalCode, phone, createDate, createdBy,
     * lastUpdate, lastUpdatedBy, and divisionID.
     *
     * @param customerName
     * @param address
     * @param postalCode
     * @param phone
     * @param divisionID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertCustomer(String customerName, String address, String postalCode, String phone,
                                     int divisionID) throws SQLException, Exception{
        String sqlStatement = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone," +
                "Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) " +
                "VALUES(?, ?, ?, ?, now(), ?, now(), ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        String createdBy = LoginScreenController.username;
        String lastUpdatedBy = String.valueOf(LoginScreenController.username);

        try {
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postalCode);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, createdBy);
            preparedStatement.setString(6, lastUpdatedBy);
            preparedStatement.setInt(7, divisionID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

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
     * @param divisionID
     * @param customerID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateCustomer(String customerName, String address, String postalCode, String phone,
                                     int divisionID, int customerID) throws SQLException, Exception{
        String sqlStatement = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, " +
                "Phone = ?, Last_Update = now(), Last_Updated_By = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        String lastUpdatedBy = String.valueOf(LoginScreenController.username);

        try {
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postalCode);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, lastUpdatedBy);
            preparedStatement.setInt(6, divisionID);
            preparedStatement.setInt(7, customerID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

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

        return -1;
    }

    /**
     * Method that deletes all appointments related to the customer in the appointments database by customerID.
     *
     * @param customerID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteCustomerAppointments(int customerID) throws SQLException, Exception{
        String sqlStatement = "DELETE FROM appointments WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, customerID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

//    /**
//     * Getter for customer in the customer's database by customerID.
//     *
//     * @param customerID
//     * @return customer.
//     * @throws SQLException
//     * @throws Exception
//     */
//    public static Customer getCustomer(int customerID) throws SQLException, Exception{
//        JDBC.openConnection();
//        String sqlStatement = "SELECT * FROM customers WHERE Customer_ID  = '" + customerID + "'";
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

}
