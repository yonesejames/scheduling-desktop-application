package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that views the reports in the application.
 *
 * @author Yonese James
 */
public class ReportScreenController implements Initializable {
    /**
     *  FXML table view variable for all of the reports.
     */
    @FXML
    public TableView reportsMainTableView;

    /**
     *  FXML table column variable for the report's IDs.
     */
    @FXML
    public TableColumn reportsTableColumnID;

    /**
     *  FXML table column variable for the report's title.
     */
    @FXML
    public TableColumn reportsTableColumnTitle;

    /**
     *  FXML table column variable for the report's description.
     */
    @FXML
    public TableColumn reportsTableColumnDescription;

    /**
     *  FXML table column variable for the report's type.
     */
    @FXML
    public TableColumn reportsTableColumnType;

    /**
     *  FXML table column variable for the report's location.
     */
    @FXML
    public TableColumn reportsTableColumnLocation;

    /**
     *  FXML table column variable for the report's start date and time.
     */
    @FXML
    public TableColumn reportsTableColumnStartDateAndTime;

    /**
     *  FXML table column variable for the report's end date and time.
     */
    @FXML
    public TableColumn reportsTableColumnEndDateAndTime;

    /**
     *  FXML table column variable for the report's customer IDs.
     */
    @FXML
    public TableColumn reportsTableColumnCustomerID;

    /**
     * FXML choice box variable to select a contact for the report.
     */
    @FXML
    public ChoiceBox reportsSelectContactChoiceBox;

    /**
     *  FXML back button variable to revert to the main screen.
     */
    @FXML
    public Button reportsBackButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button reportsLogoutButton;

    /**
     *  FXML table view variable for the appointment reports.
     */
    @FXML
    public TableView reportsLeftTableView;

    /**
     *  FXML table column variable for the appointment report's month.
     */
    @FXML
    public TableColumn reportsColumnAppointmentMonth;

    /**
     *  FXML table column variable for the appointment report's type.
     */
    @FXML
    public TableColumn reportsColumnAppointmentType;

    /**
     *  FXML table column variable for the appointment report's total appointments.
     */
    @FXML
    public TableColumn reportsColumnTotalAppointments;

    /**
     *  FXML table view variable for the division reports.
     */
    @FXML
    public TableView reportsRightTableView;

    /**
     *  FXML table column variable for the division report's name.
     */
    @FXML
    public TableColumn reportsColumnDivisionName;

    /**
     *  FXML table column variable for the division report's total customers.
     */
    @FXML
    public TableColumn reportsColumnTotalCustomers;


    /**
     * Initialize method for the ReportScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * reportsBackButtonAction method to go back to main screen.
     *
     * @param actionEvent
     */
    public void reportsBackButtonAction(ActionEvent actionEvent) {
    }

    /**
     * reportsLogoutButtonAction method to log out of the application.
     *
     * @param actionEvent
     */
    public void reportsLogoutButtonAction(ActionEvent actionEvent) {
    }
}
