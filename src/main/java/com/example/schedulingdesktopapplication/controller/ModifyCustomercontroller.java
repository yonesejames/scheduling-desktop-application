package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that edits the customers in the application.
 *
 * @author Yonese James
 */
public class ModifyCustomercontroller implements Initializable {
    /**
     * Variables for the ModifyCustomercontroller within the view files.
     */
    @FXML
    public TextField modifyCustomerIDTextField;
    @FXML
    public TextField modifyCustomerNameTextField;
    @FXML
    public TextField modifyCustomerAddressTextField;
    @FXML
    public TextField modifyCustomerPhoneNumberTextField;
    @FXML
    public TextField modifyCustomerPostalCodeTextField;

    /**
     * Initialize method for the ModifyCustomercontroller to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * modifyCustomerSaveButtonAction method to save the modified customer.
     *
     * @param actionEvent
     */
    public void modifyCustomerSaveButtonAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerCancelButtonAction method to cancel customer.
     *
     * @param actionEvent
     */
    public void modifyCustomerCancelButtonAction(ActionEvent actionEvent) {
    }
}