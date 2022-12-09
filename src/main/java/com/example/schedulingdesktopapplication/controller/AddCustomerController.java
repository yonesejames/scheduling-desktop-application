package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that adds customers in the application.
 *
 * @author Yonese James
 */
public class AddCustomerController implements Initializable {
    /**
     * FXML text field variable for the customer's ID.
     */
    @FXML
    public TextField addCustomerIDTextField;

    /**
     * FXML text field variable for the customer's name.
     */
    @FXML
    public TextField addCustomerNameTextField;

    /**
     * FXML text field variable for the customer's address.
     */
    @FXML
    public TextField addCustomerAddressTextField;

    /**
     * FXML text field variable for the customer's phone number.
     */
    @FXML
    public TextField addCustomerPhoneNumberTextField;

    /**
     * FXML text field variable for the customer's postal code.
     */
    @FXML
    public TextField addCustomerPostalCodeTextField;

    /**
     * FXML text field variable for the customer's country.
     */
    @FXML
    public ChoiceBox addCustomerCountryChoiceBox;

    /**
     * FXML text field variable for the customer's state or province.
     */
    @FXML
    public ChoiceBox addCustomerStateOrProvinceChoiceBox;

    /**
     * FXML button variable to save the customer.
     */
    @FXML
    public Button addCustomerSaveButton;

    /**
     * FXML button variable to cancel the customer.
     */
    @FXML
    public Button addCustomerCancelButton;

    /**
     * Initialize method for the AddCustomerController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * addCustomerSaveAction method to save customer.
     *
     * @param actionEvent
     */
    public void addCustomerSaveAction(ActionEvent actionEvent) {
    }

    /**
     * addCustomerCancelAction method to cancel customer.
     *
     * @param actionEvent
     */
    public void addCustomerCancelAction(ActionEvent actionEvent) {
    }
}
