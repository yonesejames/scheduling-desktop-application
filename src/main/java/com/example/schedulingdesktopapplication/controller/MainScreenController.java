package com.example.schedulingdesktopapplication.controller;

import com.example.schedulingdesktopapplication.DAO.AppointmentDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Appointment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class that views the main screen after logging into the application.
 *
 * @author Yonese James
 */
public class MainScreenController implements Initializable {
    /**
     *  FXML customers button variable to go to the customers page.
     */
    @FXML
    public Button mainCustomersButton;

    /**
     *  FXML appointments button variable to go to the appointments page.
     */
    @FXML
    public Button mainAppointmentsButton;

    /**
     *  FXML reports button variable to go to the customers page.
     */
    @FXML
    public Button mainReportsButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button mainLogoutButton;

    /**
     * Initialize method for the MainScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ObservableList<Appointment> upcomingFifteenAppointments = AppointmentDAO.getFifteenMinuteAppointments();


            if (!upcomingFifteenAppointments.isEmpty()) {
                for (Appointment appointment : upcomingFifteenAppointments) {
                    String informationMessage = "UPCOMING APPOINTMENT: Appointment ID: " + appointment.getAppointmentID()
                            + " | Date: " + appointment.getStartDateTime().toLocalDateTime().toLocalDate() + " Time: "
                            + appointment.getStartDateTime().toLocalDateTime().toLocalTime();
                    alertMessage("Information", informationMessage);
                }
            } else {
                alertMessage("Information", "NO UPCOMING APPOINTMENTS WITHIN 15 MINUTES");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * showScreen method that allows another screen to be shown.
     *
     * @throws IOException when screen does not show.
     * @param actionEvent for screen.
     * @param viewPath for view file
     * @param title for screen title.
     */
    public void showScreen(ActionEvent actionEvent, String viewPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(viewPath));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * alertMessage method that shows an alert message and text.
     *
     * @param alertType for alert type.
     * @param alertText for alert message.
     */
    public void alertMessage(String alertType, String alertText) {
        switch (alertType) {
            case "Error":
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("ERROR");
                errorAlert.setContentText(alertText);
                errorAlert.showAndWait();
                break;
            case "Warning":
                Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                warningAlert.setTitle("WARNING");
                warningAlert.setContentText(alertText);
                warningAlert.showAndWait();
                break;
            case "Confirmation":
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("CONFIRMATION");
                confirmationAlert.setContentText(alertText);
                confirmationAlert.showAndWait();
                break;
            case "Information":
                Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
                informationAlert.setTitle("INFORMATION");
                informationAlert.setContentText(alertText);
                informationAlert.showAndWait();
                break;
        }
    }

    /**
     * mainCustomersButtonAction method to go to the customers page and view customers.
     *
     * @throws IOException when customers button does not work.
     * @param actionEvent for customers.
     */
    public void mainCustomersButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/CustomerScreenView.fxml", "Customers");
    }

    /**
     * mainAppointmentsButtonAction method to go to the appointments page and view appointments.
     *
     * @throws IOException when appointments button does not work.
     * @param actionEvent for appointments.
     */
    public void mainAppointmentsButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/AppointmentScreenView.fxml", "Appointments");
    }

    /**
     * mainReportsButtonAction method to go to the reports page and view reports.
     *
     * @throws IOException when reports button does not work.
     * @param actionEvent for reports.
     */
    public void mainReportsButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/ReportScreenView.fxml", "Reports");
    }

    /**
     * mainLogoutButtonAction method to log out of the application.
     *
     * @param actionEvent for logout.
     */
    public void mainLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
