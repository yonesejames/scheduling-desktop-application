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
     * Variables for the AddCustomerController within the view files.
     */
    @FXML
    public RadioButton appointmentCurrentWeekRadioButton;
    @FXML
    public RadioButton appointmentCurrentMonthRadioButton;
    @FXML
    public RadioButton allAppointmentsRadioButton;
    public TableView appointmentTableView;
    public TableColumn appointmentTableColumnID;
    public TableColumn appointmentTableColumnTitle;
    public TableColumn appointmentTableColumnType;
    public TableColumn appointmentTableColumnDescription;
    public TableColumn appointmentTableColumnLocation;
    public TableColumn appointmentTableColumnStartDateAndTime;
    public TableColumn appointmentTableColumnEndDateAndTime;
    public TableColumn appointmentTableColumnContact;
    public TableColumn appointmentTableColumnCustomerID;
    public TableColumn appointmentTableColumnUserID;
    public Button appointmentReportsButton;
    public Button appointmentAddButton;
    public Button appointmentModifyButton;
    public Button appointmentDeleteButton;
    public Button appointmentsLogoutButton;
    public Label appointmentTimeZone;

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
     * appointmentsAddButtonAction method to go to the
     * add appointment page and add an appointment.
     *
     * @param actionEvent
     */
    public void appointmentsAddButtonAction(ActionEvent actionEvent) {
    }

    /**
     * allAppointmentsRadioButtonAction method to go to the
     * modify appointment page and modify the appointment.
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
     * allAppointmentsRadioButtonAction method to logout of the application.
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
}
