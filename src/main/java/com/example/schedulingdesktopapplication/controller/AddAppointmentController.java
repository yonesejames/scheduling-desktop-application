package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
     * FXML text field variable for the appointment's ID.
     */
    @FXML
    public TextField addAppointmentIDTextField;

    /**
     * FXML text field variable for the appointment's title.
     */
    @FXML
    public TextField addAppointmentTitleTextField;

    /**
     * FXML text field variable for the appointment's type.
     */
    @FXML
    public TextField addAppointmentTypeTextField;

    /**
     * FXML text field variable for the appointment's description.
     */
    @FXML
    public TextField addAppointmentDescriptionTextField;

    /**
     * FXML text field variable for the appointment's location.
     */
    @FXML
    public TextField addAppointmentLocationTextField;

    /**
     * FXML choice box variable for the appointment's start time.
     */
    @FXML
    public ChoiceBox addAppointmentStartTimeChoiceBox;

    /**
     * FXML choice box variable for the appointment's contact.
     */
    @FXML
    public ChoiceBox addAppointmentContactChoiceBox;

    /**
     * FXML choice box variable for the appointment's user ID.
     */
    @FXML
    public ChoiceBox addAppointmentUserIDChoiceBox;

    /**
     * FXML choice box variable for the appointment's customer ID.
     */
    @FXML
    public ChoiceBox addAppointmentCustomerIDChoiceBox;

    /**
     * FXML choice box variable for the appointment's end time.
     */
    @FXML
    public ChoiceBox addAppointmentEndTimeChoiceBox;

    /**
     * FXML date picker variable for the appointment's start date.
     */
    @FXML
    public DatePicker addAppointmentStartDateDatePicker;

    /**
     * FXML button variable to save the appointment.
     */
    @FXML
    public Button addAppointmentSaveButton;

    /**
     * FXML button variable to cancel the appointment.
     */
    @FXML
    public Button addAppointmentCancelButton;

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
