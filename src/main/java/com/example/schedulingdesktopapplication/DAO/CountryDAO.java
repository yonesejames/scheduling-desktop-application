package com.example.schedulingdesktopapplication.DAO;
import com.example.schedulingdesktopapplication.model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * DAO class to access the countries database.
 *
 * @author Yonese James
 */
public class CountryDAO {
    /**
     * Getter for customer in the customer database by customerID.
     *
     * @param countryID
     * @return country.
     * @throws SQLException
     * @throws Exception
     */
    public static Country getCountry (int countryID) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM countries WHERE Country_ID  = '" + countryID + "'";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        Country countryResult;
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String country = result.getString("Country");
                Timestamp createDate = result.getTimestamp("Create_Date");
                String createdBy = result.getString("Created_By");
                Timestamp lastUpdate = result.getTimestamp("Last_Update");
                String lastUpdatedBy = result.getString("Last_Update_BY");
                countryResult = new Country(countryID, country, createDate, createdBy, lastUpdate, lastUpdatedBy);
                return countryResult;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for all countries in the countries database.
     *
     * @return ObservableList of all customers.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Country> getAllCountries () throws SQLException, Exception{
        ObservableList<Country> countries = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM countries";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                int countryID = result.getInt("Country_ID");
                String country = result.getString("Country");
                Country countryResult = new Country(countryID, country);
                countries.add(countryResult);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    /**
     * Method that inserts a country by countryID, country ,createDate, createdBy, lastUpdate, and lastUpdatedBy.
     *
     * @param countryID
     * @param country
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int insertCountry (int countryID, String country, Timestamp createDate, String createdBy,
                                     Timestamp lastUpdate, String lastUpdatedBy) throws SQLException, Exception{
        String sqlStatement = "INSERT INTO countries (Country_ID, Country, Create_Date, Created_By, Last_Update, " +
                "Last_Updated_By) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, countryID);
            preparedStatement.setString(2, country);
            preparedStatement.setTimestamp(3, createDate);
            preparedStatement.setString(4, createdBy);
            preparedStatement.setTimestamp(5, lastUpdate);
            preparedStatement.setString(6, lastUpdatedBy);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Method that updates a country by country ,createDate, createdBy, lastUpdate, and lastUpdatedBy.
     *
     * @param country
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param countryID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int updateCountry (String country, Timestamp createDate, String createdBy, Timestamp lastUpdate,
                                     String lastUpdatedBy, int countryID) throws SQLException, Exception{
        String sqlStatement = "UPDATE countries SET Country = ? AND SET Create_Date = ? AND SET Created_By = ? " +
                "AND SET Last_Update = ? AND SET Last_Updated_By = ? AND SET Division_ID = ? WHERE Country_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setString(1, country);
            preparedStatement.setTimestamp(2, createDate);
            preparedStatement.setString(3, createdBy);
            preparedStatement.setTimestamp(4, lastUpdate);
            preparedStatement.setString(5, lastUpdatedBy);
            preparedStatement.setInt(6, countryID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Method that deletes a country in the country database by countryID.
     *
     * @param countryID
     * @return the number of rows affected by this change.
     * @throws SQLException
     * @throws Exception
     */
    public static int deleteCountry (int countryID) throws SQLException, Exception{
        String sqlStatement = "DELETE FROM countries WHERE Country_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);

        try {
            preparedStatement.setInt(1, countryID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
