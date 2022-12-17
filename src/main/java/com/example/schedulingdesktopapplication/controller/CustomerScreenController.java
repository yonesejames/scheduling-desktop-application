package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that views customers in the application.
 *
 * @author Yonese James
 */
public class CustomerScreenController implements Initializable {
    public TableView customerTableView;
    public TableColumn customerTableColumnID;
    public TableColumn customerTableColumnName;
    public TableColumn customerTableColumnAddress;
    public TableColumn customerTableColumnPhoneNumber;
    public TableColumn customerTableColumnStateAndProvince;
    public TableColumn customerTableColumnPostalCode;
    public RadioButton customerCurrentWeekRadioButton;
    public RadioButton customerCurrentMonthRadioButton;
    public RadioButton customerAllAppointmentsRadioButton;
    public Button customerReportsButton;
    public Button customerAddButton;
    public Button customerModifyButton;
    public Button customerDeleteButton;
    public Button customerLogoutButton;
    public Label customerTimeZone;

    /**
     * Initialize method for the CustomerScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * customersReportsButtonAction method to go to the reports page and view reports.
     *
     * @param actionEvent
     */
    public void customersReportsButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customersAddButtonAction method go to the
     * add customer page and add a customer.
     *
     * @param actionEvent
     */
    public void customersAddButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customersModifyButtonAction method to go to the
     * modify customer page and modify the customer.
     *
     * @param actionEvent
     */
    public void customersModifyButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customersDeleteButtonAction method to delete an customer.
     *
     * @param actionEvent
     */
    public void customersDeleteButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customersLogoutButtonAction method to logout of the application.
     *
     * @param actionEvent
     */
    public void customersLogoutButtonAction(ActionEvent actionEvent) {
    }

    public void customerCurrentWeekRadioButtonAction(ActionEvent actionEvent) {
    }

    public void customerCurrentMonthRadioButtonAction(ActionEvent actionEvent) {
    }

    public void customerAllAppointmentsRadioButtonAction(ActionEvent actionEvent) {
    }

    public void customerReportsButtonAction(ActionEvent actionEvent) {
    }

    public void customerAddButtonAction(ActionEvent actionEvent) {
    }

    public void customerModifyButtonAction(ActionEvent actionEvent) {
    }

    public void customerDeleteButtonAction(ActionEvent actionEvent) {
    }

    public void customerLogoutButtonAction(ActionEvent actionEvent) {
    }
}