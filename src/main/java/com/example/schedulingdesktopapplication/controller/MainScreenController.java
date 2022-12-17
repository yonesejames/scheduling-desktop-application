package com.example.schedulingdesktopapplication.controller;

import com.example.schedulingdesktopapplication.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
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

    }

    /**
     * mainCustomersButtonAction method to go to the customers page and view customers.
     *
     * @param actionEvent
     */
    public void mainCustomersButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * mainAppointmentsButtonAction method to go to the appointments page and view appointments.
     *
     * @param actionEvent
     */
    public void mainAppointmentsButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/AppointmentScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * mainReportsButtonAction method to go to the reports page and view reports.
     *
     * @param actionEvent
     */
    public void mainReportsButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/ReportScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * mainLogoutButtonAction method to log out of the application.
     *
     * @param actionEvent
     */
    public void mainLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
