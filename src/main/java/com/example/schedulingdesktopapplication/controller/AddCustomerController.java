package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
     * Variables for the AddCustomerController within the view files.
     */
    @FXML
    public TextField addCustomerIDTextField;
    @FXML
    public TextField addCustomerNameTextField;
    @FXML
    public TextField addCustomerAddressTextField;
    @FXML
    public TextField addCustomerPhoneNumberTextField;
    @FXML
    public TextField addCustomerPostalCodeTextField;

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
