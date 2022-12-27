package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that views appointments in the application.
 *
 * @author Yonese James
 */
public class AppointmentScreenController implements Initializable {
    /**
     * FXML radio button field variable to view current week appointments.
     */
    @FXML
    public RadioButton appointmentCurrentWeekRadioButton;

    /**
     * FXML radio button field variable to view current month appointments.
     */
    @FXML
    public RadioButton appointmentCurrentMonthRadioButton;

    /**
     * FXML radio button field variable to view all appointments.
     */
    @FXML
    public RadioButton allAppointmentsRadioButton;

    /**
     *  FXML table view variable for the appointments.
     */
    @FXML
    public TableView appointmentTableView;

    /**
     *  FXML table column variable for the appointment's IDs.
     */
    @FXML
    public TableColumn appointmentTableColumnID;

    /**
     *  FXML table column variable for the appointment's titles.
     */
    @FXML
    public TableColumn appointmentTableColumnTitle;

    /**
     *  FXML table column variable for the appointment's types.
     */
    @FXML
    public TableColumn appointmentTableColumnType;

    /**
     *  FXML table column variable for the appointment's description.
     */
    @FXML
    public TableColumn appointmentTableColumnDescription;

    /**
     *  FXML table column variable for the appointment's location.
     */
    @FXML
    public TableColumn appointmentTableColumnLocation;

    /**
     *  FXML table column variable for the appointment's start date and time.
     */
    @FXML
    public TableColumn appointmentTableColumnStartDateAndTime;

    /**
     *  FXML table column variable for the appointment's end date and time.
     */
    @FXML
    public TableColumn appointmentTableColumnEndDateAndTime;

    /**
     *  FXML table column variable for the appointment's contact.
     */
    @FXML
    public TableColumn appointmentTableColumnContact;

    /**
     *  FXML table column variable for the appointment's customer IDs.
     */
    @FXML
    public TableColumn appointmentTableColumnCustomerID;

    /**
     *  FXML table column variable for the appointment's user IDs.
     */
    @FXML
    public TableColumn appointmentTableColumnUserID;

    /**
     *  FXML reports button variable to view reports.
     */
    @FXML
    public Button appointmentReportsButton;

    /**
     *  FXML add button variable to add an appointment.
     */
    @FXML
    public Button appointmentAddButton;

    /**
     *  FXML modify button variable to modify the selected appointment.
     */
    @FXML
    public Button appointmentModifyButton;

    /**
     *  FXML delete button variable to delete the selected appointment.
     */
    @FXML
    public Button appointmentDeleteButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button appointmentsLogoutButton;

    /**
     *  FXML label variable for the appointment's timezone.
     */
    @FXML
    public Label appointmentTimeZone;

    /**
     *  FXML back button variable to go to the main menu of the application.
     */
    @FXML
    public Button appointmentsBackButton;

    /**
     * Initialize method for the AppointmentScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * appointmentCurrentWeekRadioButtonAction method to view current week of appointments.
     *
     * @param actionEvent
     */
    public void appointmentCurrentWeekRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentCurrentMonthRadioButtonAction method to view current month of appointments.
     *
     * @param actionEvent
     */
    public void appointmentCurrentMonthRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * allAppointmentsRadioButtonAction method to view all appointments.
     *
     * @param actionEvent
     */
    public void allAppointmentsRadioButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentReportsButtonAction method to go to the reports page and view reports.
     *
     * @param actionEvent
     */
    public void appointmentReportsButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentsAddButtonAction method to go to the add appointment page and add an appointment.
     *
     * @param actionEvent
     */
    public void appointmentsAddButtonAction(ActionEvent actionEvent) {
    }

    /**
     * allAppointmentsRadioButtonAction method to go to the modify appointment page and modify the appointment.
     *
     * @param actionEvent
     */
    public void appointmentsModifyButtonAction(ActionEvent actionEvent) {
    }

    /**
     * allAppointmentsRadioButtonAction method to delete an appointment.
     *
     * @param actionEvent
     */
    public void appointmentsDeleteButtonAction(ActionEvent actionEvent) {
    }

    /**
     * allAppointmentsRadioButtonAction method to exit the application.
     *
     * @param actionEvent
     */
    public void appointmentsLogoutButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentAddButtonAction method to add an appointment.
     *
     * @param actionEvent
     */
    public void appointmentAddButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentModifyButtonAction method to modify a selected appointment.
     *
     * @param actionEvent
     */
    public void appointmentModifyButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentDeleteButtonAction method to delete a selected appointment.
     *
     * @param actionEvent
     */
    public void appointmentDeleteButtonAction(ActionEvent actionEvent) {
    }

    /**
     * appointmentBackButtonAction method to go to the main menu of the application.
     *
     * @param actionEvent
     */
    public void appointmentsBackButtonAction(ActionEvent actionEvent) {
    }
}
