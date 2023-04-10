package com.example.schedulingdesktopapplication.DAO;

import com.example.schedulingdesktopapplication.model.Customer;
import com.example.schedulingdesktopapplication.model.FirstLevelDivision;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FirstLevelDivisionDAO {
    /**
     * Getter for first level divisions in the first_level_divisions database by divisionID.
     *
     * @param divisionID
     * @return country.
     * @throws SQLException
     * @throws Exception
     */
    public static FirstLevelDivision getFirstLevelDivision (int divisionID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT * FROM first_level_divisions WHERE Division_ID  = '" + divisionID + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        FirstLevelDivision countryResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String division = result.getString("Division");
                Timestamp createDate = result.getTimestamp("Create_Date");
                String createdBy = result.getString("Created_By");
                Timestamp lastUpdate = result.getTimestamp("Last_Update");
                String lastUpdatedBy = result.getString("Last_Update_BY");
                int countryID = result.getInt("Country_ID");
                countryResult = new FirstLevelDivision(divisionID, division, createDate, createdBy, lastUpdate,
                        lastUpdatedBy, countryID);
                return countryResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Getter for division in the first_level_divisions database by divisionID.
     *
     * @param divisionID
     * @return division.
     * @throws SQLException
     * @throws Exception
     */
    public static String getDivision(int divisionID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "SELECT Division FROM first_level_divisions WHERE Division_ID  = '" + divisionID + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        String divisionResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String division = result.getString("Division");
                divisionResult = division;
                return divisionResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Getter for all first level divisions in the first_level_divisions database.
     *
     * @return ObservableList of all firstLevelDivisions.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<FirstLevelDivision> getAllFirstLevelDivision () throws SQLException, Exception{
        JDBC.openConnection();
        ObservableList<FirstLevelDivision> firstLevelDivisions = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM first_level_divisions";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int divisionID = result.getInt("Division_ID");
                String division = result.getString("Division");
                Timestamp createDate = result.getTimestamp("Create_Date");
                String createdBy = result.getString("Created_By");
                Timestamp lastUpdate = result.getTimestamp("Last_Update");
                String lastUpdatedBy = result.getString("Last_Update_BY");
                int countryID = result.getInt("Country_ID");
                FirstLevelDivision customerResult = new FirstLevelDivision(divisionID, division, createDate, createdBy,
                        lastUpdate, lastUpdatedBy, countryID);
                firstLevelDivisions.add(customerResult);
                JDBC.closeConnection();
            }
            return firstLevelDivisions;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.closeConnection();
        return null;
    }

    /**
     * Method that inserts a firstLevelDivisions by divisionID, division ,createDate, createdBy, lastUpdate, lastUpdatedBy,
     * and countryID.
     *
     * @param divisionID
     * @param division
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param countryID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertFirstLevelDivision (int divisionID, String division, Timestamp createDate, String createdBy,
                                     Timestamp lastUpdate, String lastUpdatedBy, int countryID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "INSERT INTO first_level_divisions (Division_ID, Division, Create_Date, Created_By, Last_Update, " +
                "Last_Updated_By, Country_ID) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, divisionID);
            preparedStatement.setString(2, division);
            preparedStatement.setTimestamp(3, createDate);
            preparedStatement.setString(4, createdBy);
            preparedStatement.setTimestamp(5, lastUpdate);
            preparedStatement.setString(6, lastUpdatedBy);
            preparedStatement.setInt(7, countryID);
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
     * Method that updates a firstLevelDivision by divisionID, division ,createDate, createdBy, lastUpdate, lastUpdatedBy,
     * and countryID.
     *
     * @param divisionID
     * @param division
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param countryID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateFirstLevelDivision (int divisionID, String division, Timestamp createDate, String createdBy,
                                                Timestamp lastUpdate, String lastUpdatedBy, int countryID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "UPDATE first_level_divisions SET Division = ? AND SET Create_Date = ? " +
                "AND SET Created_By = ? AND SET Last_Update = ? AND SET Last_Updated_By = ? AND SET Country_ID = ? " +
                "WHERE Division_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, division);
            preparedStatement.setTimestamp(2, createDate);
            preparedStatement.setString(3, createdBy);
            preparedStatement.setTimestamp(4, lastUpdate);
            preparedStatement.setString(5, lastUpdatedBy);
            preparedStatement.setInt(6, countryID);
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
     * Method that deletes a country in the country database by countryID.
     *
     * @param divisionID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteFirstLevelDivision (int divisionID) throws SQLException, Exception{
        JDBC.openConnection();
        String sqlStatement = "DELETE FROM first_level_divisions WHERE Division_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, divisionID);
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
