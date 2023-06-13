package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.AppointmentDAO;
import com.example.schedulingdesktopapplication.DAO.ContactDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static com.example.schedulingdesktopapplication.DAO.ContactDAO.getContactID;
import static com.example.schedulingdesktopapplication.DAO.UserDAO.getUserID;
import static com.example.schedulingdesktopapplication.model.Logger.getZoneId;

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
    public Label addAppointmentIDLabel;

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
     * FXML combo box variable for the appointment's start time.
     */
    @FXML
    public ComboBox<LocalTime> addAppointmentStartTimeComboBox;

    /**
     * FXML combo box variable for the appointment's contact.
     */
    @FXML
    public ComboBox addAppointmentContactComboBox;

    /**
     * FXML combo box variable for the appointment's user ID.
     */
    @FXML
    public Label addAppointmentUserIDLabel;

    /**
     * FXML combo box variable for the appointment's customer IDs.
     */
    @FXML
    public ComboBox<Integer> addAppointmentCustomerIDComboBox;
    /**
     * FXML combo box variable for the appointment's end time.
     */
    @FXML
    public ComboBox<LocalTime> addAppointmentEndTimeComboBox;

    /**
     * FXML date picker variable for the appointment's start date.
     */
    @FXML
    public DatePicker addAppointmentStartDateDatePicker;

    /**
     * FXML date picker variable for the appointment's end date.
     */
    @FXML
    public DatePicker addAppointmentEndDateDatePicker;

    /**
     * FXML button variable to save the appointment.
     */
    @FXML
    public Button addAppointmentSaveButton;

    /**
     *  FXML cancel button variable to revert back to the main screen.
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
        try {
            addAppointmentContactComboBox.setItems(ContactDAO.getContactNames());
            addAppointmentStartDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));
            addAppointmentEndDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));
            for(int i = 0; i < 24; i++) {
                addAppointmentStartTimeComboBox.getItems().add(LocalTime.of(i, 0));
                addAppointmentEndTimeComboBox.getItems().add(LocalTime.of(i, 0));
            }
            addAppointmentCustomerIDComboBox.setItems(CustomerDAO.getCustomerIDs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * showScreen method that allows another screen to be shown.
     *
     * @throws Exception
     * @param actionEvent
     * @param viewPath
     * @param title
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
     * @param alertType
     * @param alertText
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
        }
    }

    /**
     * addAppointmentSaveAction method to save appointment.
     *
     * @param actionEvent
     */
    public void addAppointmentSaveAction(ActionEvent actionEvent) throws Exception {
        String appointmentTitle = addAppointmentTitleTextField.getText();
        String appointmentType = addAppointmentTypeTextField.getText();
        String appointmentDescription = addAppointmentDescriptionTextField.getText();
        String appointmentLocation = addAppointmentLocationTextField.getText();
        LocalDate appointmentStartDate = addAppointmentStartDateDatePicker.getValue();
        LocalDate appointmentEndDate = addAppointmentEndDateDatePicker.getValue();
        LocalTime appointmentStartTime = addAppointmentStartTimeComboBox.getValue();
        LocalTime appointmentEndTime = addAppointmentEndTimeComboBox.getValue();
        Integer appointmentCustomerID = addAppointmentCustomerIDComboBox.getValue();
        String appointmentContact = String.valueOf(addAppointmentContactComboBox.getValue());
        Integer appointmentContactID = getContactID(appointmentContact);
        Integer userID = getUserID(String.valueOf(LoginScreenController.username));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime appointmentStartDateTime = null;
        LocalDateTime appointmentEndDateTime = null;
        appointmentStartDateTime = LocalDateTime.of(LocalDate.parse(String.valueOf(appointmentStartDate), dateFormatter),
                LocalTime.parse(String.valueOf(appointmentStartTime),
                timeFormatter));
        System.out.println(appointmentStartDateTime);
        appointmentEndDateTime = LocalDateTime.of(appointmentEndDate, appointmentEndTime);

        ZonedDateTime appointmentZoneStartDateTime = ZonedDateTime.of(appointmentStartDateTime, getZoneId());
        ZonedDateTime appointmentZoneEndDateTime = ZonedDateTime.of(appointmentEndDateTime, getZoneId());
        ZonedDateTime startBusinessHoursEST = ZonedDateTime.of(appointmentStartDate, LocalTime.of(8,0),
                ZoneId.of("America/New_York"));
        ZonedDateTime endBusinessHoursEST = ZonedDateTime.of(appointmentEndDate,LocalTime.of(22, 0),
                ZoneId.of("America/New_York"));

        ZonedDateTime appointmentUTCStartDateTime = appointmentZoneStartDateTime.withZoneSameInstant(ZoneOffset.UTC);
        String stringUTCStart = String.valueOf(appointmentUTCStartDateTime);
        ZonedDateTime startZDT = ZonedDateTime.parse(stringUTCStart, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String start = String.valueOf(startZDT);

        ZonedDateTime appointmentUTCEndDateTime = appointmentZoneEndDateTime.withZoneSameInstant(ZoneOffset.UTC);
        String stringUTCEnd = String.valueOf(appointmentUTCEndDateTime);
        ZonedDateTime  endZDT = ZonedDateTime.parse(stringUTCEnd, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String end = String.valueOf(endZDT);

        if (appointmentTitle.isBlank()) {
            alertMessage("Error", "PLEASE ENTER TITLE");
        }
        else if (appointmentType.isBlank()) {
            alertMessage("Error", "PLEASE ENTER TYPE");
        }
        else if (appointmentLocation.isBlank()) {
            alertMessage("Error", "PLEASE ENTER LOCATION");
        }
        else if (appointmentEndDate.isBefore(appointmentStartDate)) {
            alertMessage("Error", "END DATE CANNOT BE BEFORE START DATE");
        }
        else if (appointmentEndTime.isBefore(appointmentStartTime)) {
            alertMessage("Error", "END TIME CANNOT BE BEFORE START TIME");
        }
        else if (appointmentContact.isBlank()) {
            alertMessage("Error", "PLEASE ENTER CONTACT");
        }
        else if (appointmentZoneStartDateTime.isBefore(startBusinessHoursEST)) {
            alertMessage("Error", "PLEASE ENTER TIME BETWEEN 8 AM - 10 PM EST.");
        }
        else if (appointmentZoneEndDateTime.isAfter(endBusinessHoursEST)) {
            alertMessage("Error", "PLEASE ENTER TIME BETWEEN 8 AM - 10 PM EST.");
        }
        else if (appointmentCustomerID == null) {
            alertMessage("Error", "PLEASE ENTER Customer ID");
        }

        String createdBy = String.valueOf(LoginScreenController.username);

        int appointmentAdded = AppointmentDAO.insertAppointment(appointmentTitle, appointmentDescription, appointmentLocation,
                appointmentType, start, end, createdBy, createdBy, appointmentContactID,
                userID, appointmentCustomerID);

        if (appointmentAdded != -1) {
            alertMessage("Confirmation", "APPOINTMENT HAS BEEN ADDED");
            showScreen(actionEvent, "view/AppointmentScreenView.fxml", "Appointments");
        } else {
            alertMessage("Error", "APPOINTMENT HAS NOT BEEN ADDED");
        }
    }

    /**
     * addAppointmentCancelAction method to cancel appointment.
     *
     * @param actionEvent
     */
    public void addAppointmentCancelAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/AppointmentScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    public void addAppointmentTitleAction(ActionEvent actionEvent) {
    }

    public void addAppointmentTypeAction(ActionEvent actionEvent) {
    }

    public void addAppointmentDescriptionAction(ActionEvent actionEvent) {
    }

    public void addAppointmentLocationAction(ActionEvent actionEvent) {
    }

    public void addAppointmentStartTime(ActionEvent actionEvent) {
    }

    public void addAppointmentEndTimeAction(ActionEvent actionEvent) {
    }

    public void addAppointmentStartDateAction(ActionEvent actionEvent) {
    }

    public void addAppointmentEndDateAction(ActionEvent actionEvent) {
    }
}
