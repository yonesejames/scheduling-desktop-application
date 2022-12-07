package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that adds appointments in the application.
 *
 * @author Yonese James
 */
public class AddAppointmentController implements Initializable {
    /**
     * Variables for the AddAppointmentController within the view files.
     */
    @FXML
    public TextField addAppointmentIDTextField;
    @FXML
    public TextField addAppointmentTitleTextField;
    @FXML
    public TextField addAppointmentTypeTextField;
    @FXML
    public TextField addAppointmentDescriptionTextField;
    @FXML
    public TextField addAppointmentLocationTextField;

    /**
     * Initialize method for the AddAppointmentController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * addAppointmentSaveAction method to save appointment.
     *
     * @param actionEvent
     */
    public void addAppointmentSaveAction(ActionEvent actionEvent) {
    }

    /**
     * addAppointmentCancelAction method to cancel appointment.
     *
     * @param actionEvent
     */
    public void addAppointmentCancelAction(ActionEvent actionEvent) {
    }
}
