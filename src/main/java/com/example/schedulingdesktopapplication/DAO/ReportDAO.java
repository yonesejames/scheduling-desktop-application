package com.example.schedulingdesktopapplication.DAO;
import com.example.schedulingdesktopapplication.model.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO class to access different tables in the database.
 *
 * @author Yonese James
 */
public class ReportDAO {

    /**
     * Getter for all appointment months and types in the appointment database.
     *
     * @return ObservableList of all appointments by months and types.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Report> getAllAppointmentsByMonthAndType() throws SQLException, Exception{
        ObservableList<Report> allAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT MONTHNAME(Start) as \"Month\", COUNT(MONTH(Start)) as \"Month Total\",  Type, " +
                "COUNT(Type) as \"Type Total\" from appointments GROUP BY Month";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String appointmentMonth = result.getString("Month");
                int appointmentMonthTotal = result.getInt("Month Total");
                String appointmentType = result.getString("Type");
                int appointmentTypeTotal = result.getInt("Type Total");

                Report report = new Report(appointmentMonth, appointmentMonthTotal, appointmentType, appointmentTypeTotal);
                allAppointments.add(report);
            }
            return allAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for total customers based on certain divisions.
     *
     * @return ObservableList of customers based on certain divisions.
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Report> getTotalCustomersByDivision() throws SQLException, Exception{
        ObservableList<Report> allAppointments = FXCollections.observableArrayList();
        String sqlStatement = "SELECT Division as \"Division Name\", COUNT(Customer_Name) as \"Customer Total\" " +
                "FROM first_level_divisions as fld INNER JOIN customers as c ON fld.Division_ID = c.Division_ID GROUP BY Division";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet result = preparedStatement.executeQuery();

        try {
            while(result.next()){
                String divisionName = result.getString("Division Name");
                int customerTotal = result.getInt("Customer Total");

                Report report = new Report(divisionName, customerTotal);
                allAppointments.add(report);
            }
            return allAppointments;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
