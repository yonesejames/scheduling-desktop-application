package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that edits the appointments in the application.
 *
 * @author Yonese James
 */
public class ModifyAppointmentController implements Initializable {
    /**
     * Variables for the AddCustomerController within the view files.
     */
    @FXML
    public TextField modifyAppointmentIDTextField;
    @FXML
    public TextField modifyAppointmentTitleTextField;
    @FXML
    public TextField modifyAppointmentTypeTextField;
    @FXML
    public TextField modifyAppointmentDescriptionTextField;
    @FXML
    public TextField modifyAppointmentLocationTextField;

    /**
     * Initialize method for the ModifyAppointmentController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * modifyAppointmentSaveButtonAction method to save the modified appointment.
     *
     * @param actionEvent
     */
    public void modifyAppointmentSaveButtonAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentCancelButtonAction method to cancel appointment.
     *
     * @param actionEvent
     */
    public void modifyAppointmentCancelButtonAction(ActionEvent actionEvent) {
    }
}