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
 * Controller class that edits the appointments in the application.
 *
 * @author Yonese James
 */
public class ModifyAppointmentController implements Initializable {
    /**
     *  FXML text field variable for the appointment's ID.
     */
    @FXML
    public TextField modifyAppointmentIDTextField;

    /**
     *  FXML text field variable for the appointment's title.
     */
    @FXML
    public TextField modifyAppointmentTitleTextField;

    /**
     *  FXML text field variable for the appointment's type.
     */
    @FXML
    public TextField modifyAppointmentTypeTextField;

    /**
     *  FXML text field variable for the appointment's description.
     */
    @FXML
    public TextField modifyAppointmentDescriptionTextField;

    /**
     *  FXML text field variable for the appointment's location.
     */
    @FXML
    public TextField modifyAppointmentLocationTextField;

    /**
     * FXML choice box variable to select a start time for the appointment.
     */
    @FXML
    public ChoiceBox modifyAppointmentStartTimeChoiceBox;

    /**
     * FXML choice box variable to select a start time for the appointment.
     */
    @FXML
    public ChoiceBox modifyAppointmentContactChoiceBox;

    /**
     * FXML choice box variable to select a user ID for the appointment.
     */
    @FXML
    public ChoiceBox modifyAppointmentUserIDChoiceBox;

    /**
     * FXML choice box variable to select a customer ID for the appointment.
     */
    @FXML
    public ChoiceBox modifyAppointmentCustomerIDChoiceBox;

    /**
     * FXML choice box variable to select an end time for the appointment.
     */
    @FXML
    public ChoiceBox modifyAppointmentEndTimeChoiceBox;

    /**
     * FXML date picker variable to select a start date
     */
    @FXML
    public DatePicker modifyAppointmentStartDateDatePicker;

    /**
     * FXML date picker variable to select an end date
     */
    @FXML
    public DatePicker modifyAppointmentEndDateDatePicker;

    /**
     *  FXML save button variable to save the appointment.
     */
    @FXML
    public Button modifyAppointmentSaveButton;

    /**
     *  FXML cancel button variable to revert back to the main screen.
     */
    @FXML
    public Button modifyAppointmentCancelButton;

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
     * modifyAppointmentCancelButtonAction method to revert back to the main screen.
     *
     * @param actionEvent
     */
    public void modifyAppointmentCancelButtonAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentIDTextFieldAction method for the appointment's ID.
     *
     * @param actionEvent
     */
    public void modifyAppointmentIDTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentTitleTextFieldAction method for the appointment's title.
     *
     * @param actionEvent
     */
    public void modifyAppointmentTitleTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentTypeTextFieldAction method for the appointment's type.
     *
     * @param actionEvent
     */
    public void modifyAppointmentTypeTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentDescriptionTextFieldAction method for the appointment's description.
     *
     * @param actionEvent
     */
    public void modifyAppointmentDescriptionTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentLocationTextFieldAction method for the appointment's location.
     *
     * @param actionEvent
     */
    public void modifyAppointmentLocationTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentStartDateDatePickerAction method for the appointment's start date picker.
     *
     * @param actionEvent
     */
    public void modifyAppointmentStartDateDatePickerAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentEndDateDatePickerAction method for the appointment's end date picker.
     *
     * @param actionEvent
     */
    public void modifyAppointmentEndDateDatePickerAction(ActionEvent actionEvent) {
    }
}