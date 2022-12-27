package com.example.schedulingdesktopapplication.controller;

import com.example.schedulingdesktopapplication.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    /**
     *  FXML table view variable for the customers.
     */
    @FXML
    public TableView customerTableView;

    /**
     *  FXML table column variable for the customer's IDs.
     */
    @FXML
    public TableColumn customerTableColumnID;

    /**
     *  FXML table column variable for the customer's names.
     */
    @FXML
    public TableColumn customerTableColumnName;

    /**
     *  FXML table column variable for the customer's addresses.
     */
    @FXML
    public TableColumn customerTableColumnAddress;

    /**
     *  FXML table column variable for the customer's phone numbers.
     */
    @FXML
    public TableColumn customerTableColumnPhoneNumber;

    /**
     *  FXML table column variable for the customer's state and province.
     */
    @FXML
    public TableColumn customerTableColumnStateAndProvince;

    /**
     *  FXML table column variable for the customer's postal code.
     */
    @FXML
    public TableColumn customerTableColumnPostalCode;

    /**
     * FXML radio button field variable to view current week of customers.
     */
    @FXML
    public RadioButton customerCurrentWeekRadioButton;

    /**
     * FXML radio button field variable to view current month of customers.
     */
    @FXML
    public RadioButton customerCurrentMonthRadioButton;

    /**
     * FXML radio button field variable to view all the customers.
     */
    @FXML
    public RadioButton customerAllAppointmentsRadioButton;

    /**
     *  FXML reports button variable to view reports.
     */
    @FXML
    public Button customerReportsButton;

    /**
     *  FXML add button variable to add a customer.
     */
    @FXML
    public Button customerAddButton;

    /**
     *  FXML modify button variable to modify the selected customer.
     */
    @FXML
    public Button customerModifyButton;

    /**
     *  FXML delete button variable to delete the selected customer.
     */
    @FXML
    public Button customerDeleteButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button customerLogoutButton;

    /**
     *  FXML label variable for the customer's timezone.
     */
    @FXML
    public Label customerTimeZone;

    private static Customer newCustomer = new Customer();

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

    /**
     * customerCurrentWeekRadioButtonAction method to view current week of customers.
     *
     * @param actionEvent
     */
    public void customerCurrentWeekRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerCurrentMonthRadioButtonAction method to view current month of customers.
     *
     * @param actionEvent
     */
    public void customerCurrentMonthRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerAllAppointmentsRadioButtonAction method to view all customers.
     *
     * @param actionEvent
     */
    public void customerAllAppointmentsRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerReportsButtonAction method to go to the reports page and view reports.
     *
     * @param actionEvent
     */
    public void customerReportsButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerAddButtonAction method to go to the add customer page and add a customer.
     *
     * @param actionEvent
     */
    public void customerAddButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerModifyButtonAction method to go to the modify customer page and modify the customer.
     *
     * @param actionEvent
     */
    public void customerModifyButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerDeleteButtonAction method to delete a selected customer.
     *
     * @param actionEvent
     */
    public void customerDeleteButtonAction(ActionEvent actionEvent) {
    }

    /**
     * customerLogoutButtonAction method to logout of the application.
     *
     * @param actionEvent
     */
    public void customerLogoutButtonAction(ActionEvent actionEvent) {
    }
}