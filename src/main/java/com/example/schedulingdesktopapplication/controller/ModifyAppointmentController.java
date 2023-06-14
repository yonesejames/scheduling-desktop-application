package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.AppointmentDAO;
import com.example.schedulingdesktopapplication.DAO.ContactDAO;
import com.example.schedulingdesktopapplication.DAO.CountryDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Appointment;
import com.example.schedulingdesktopapplication.model.Customer;
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
import java.sql.Timestamp;
import java.time.*;
import java.util.ResourceBundle;

import static com.example.schedulingdesktopapplication.DAO.ContactDAO.getContactID;
import static com.example.schedulingdesktopapplication.DAO.UserDAO.getUserID;
import static com.example.schedulingdesktopapplication.model.Logger.getZoneId;

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
    public Label modifyAppointmentIDLabel;

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
     * FXML combo box variable to select a start time for the appointment.
     */
    @FXML
    public ComboBox<LocalTime> modifyAppointmentStartTimeComboBox;

    /**
     * FXML combo box variable to select a start time for the appointment.
     */
    @FXML
    public ComboBox modifyAppointmentContactComboBox;

    /**
     * FXML label variable to select a user ID for the appointment.
     */
    @FXML
    public Label modifyAppointmentUserIDLabel;

    /**
     * FXML combo box variable to select a customer ID for the appointment.
     */
    @FXML
    public ComboBox<Integer> modifyAppointmentCustomerIDComboBox;

    /**
     * FXML combo box variable to select an end time for the appointment.
     */
    @FXML
    public ComboBox<LocalTime> modifyAppointmentEndTimeComboBox;

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
     *  Appointment that has been selected when user clicks on appointment.
     */
    Appointment selectedAppointment;

    /**
     * Initialize method for the ModifyAppointmentController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedAppointment = AppointmentScreenController.getSelectedAppointment();
        modifyAppointmentTitleTextField.setText(selectedAppointment.getTitle());
        modifyAppointmentIDLabel.setText(String.valueOf(selectedAppointment.getAppointmentID()));
        modifyAppointmentTypeTextField.setText(selectedAppointment.getType());
        modifyAppointmentDescriptionTextField.setText(selectedAppointment.getDescription());
        modifyAppointmentLocationTextField.setText(selectedAppointment.getLocation());
        modifyAppointmentUserIDLabel.setText(String.valueOf(selectedAppointment.getUserID()));

        try {
            modifyAppointmentContactComboBox.setItems(ContactDAO.getContactNames());
            modifyAppointmentStartDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));
            modifyAppointmentEndDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));
            for(int i = 0; i < 24; i++) {
                modifyAppointmentStartTimeComboBox.getItems().add(LocalTime.of(i, 0));
                modifyAppointmentEndTimeComboBox.getItems().add(LocalTime.of(i, 0));
            }
            modifyAppointmentCustomerIDComboBox.setItems(CustomerDAO.getCustomerIDs());
            modifyAppointmentContactComboBox.getSelectionModel().select(selectedAppointment.getContactName());
            modifyAppointmentCustomerIDComboBox.getSelectionModel().select(selectedAppointment.getCustomerID());
            modifyAppointmentStartDateDatePicker.setValue(selectedAppointment.getStartDateTime().toLocalDateTime().toLocalDate());
            modifyAppointmentStartTimeComboBox.getSelectionModel().select(selectedAppointment.getStartDateTime().toLocalDateTime().toLocalTime());
            modifyAppointmentEndDateDatePicker.setValue(selectedAppointment.getEndDateTime().toLocalDateTime().toLocalDate());
            modifyAppointmentEndTimeComboBox.getSelectionModel().select(selectedAppointment.getEndDateTime().toLocalDateTime().toLocalTime());

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
     * modifyAppointmentSaveButtonAction method to save the modified appointment.
     *
     * @param actionEvent
     */
    public void modifyAppointmentSaveButtonAction(ActionEvent actionEvent) throws Exception {
        String appointmentTitle = modifyAppointmentTitleTextField.getText();
        String appointmentType = modifyAppointmentTypeTextField.getText();
        String appointmentDescription = modifyAppointmentDescriptionTextField.getText();
        String appointmentLocation = modifyAppointmentLocationTextField.getText();
        LocalDate appointmentStartDate = modifyAppointmentStartDateDatePicker.getValue();
        LocalDate appointmentEndDate = modifyAppointmentEndDateDatePicker.getValue();
        LocalTime appointmentStartTime = modifyAppointmentStartTimeComboBox.getValue();
        LocalTime appointmentEndTime = modifyAppointmentEndTimeComboBox.getValue();
        Integer appointmentCustomerID = modifyAppointmentCustomerIDComboBox.getValue();
        String appointmentContact = String.valueOf(modifyAppointmentContactComboBox.getValue());
        Integer appointmentContactID = getContactID(appointmentContact);
        Integer userID = getUserID(String.valueOf(LoginScreenController.username));
        Integer appointmentID = selectedAppointment.getAppointmentID();

        LocalDateTime appointmentStartDateTime = LocalDateTime.of(appointmentStartDate, appointmentStartTime);
        LocalDateTime appointmentEndDateTime = LocalDateTime.of(appointmentEndDate, appointmentEndTime);


        ZonedDateTime appointmentZoneStartDateTime = ZonedDateTime.of(appointmentStartDateTime, getZoneId());
        ZonedDateTime appointmentZoneEndDateTime = ZonedDateTime.of(appointmentEndDateTime, getZoneId());
        ZonedDateTime startBusinessHoursEST = ZonedDateTime.of(appointmentStartDate, LocalTime.of(8,0),
                ZoneId.of("America/New_York"));
        ZonedDateTime endBusinessHoursEST = ZonedDateTime.of(appointmentEndDate,LocalTime.of(22, 0),
                ZoneId.of("America/New_York"));


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
            alertMessage("Error", "PLEASE ENTER CUSTOMER ID");
        }

        int appointmentUpdated = AppointmentDAO.updateAppointment(appointmentTitle, appointmentDescription, appointmentLocation,
                appointmentType, Timestamp.valueOf(appointmentStartDateTime), Timestamp.valueOf(appointmentEndDateTime),
                appointmentCustomerID, userID, appointmentContactID, appointmentID);

        if (appointmentUpdated != -1) {
            alertMessage("Confirmation", "APPOINTMENT HAS BEEN UPDATED");
            showScreen(actionEvent, "view/AppointmentScreenView.fxml", "Appointments");
        } else {
            alertMessage("Error", "APPOINTMENT HAS NOT BEEN UPDATED");
        }
    }

    /**
     * modifyAppointmentCancelButtonAction method to revert back to the appointment screen.
     *
     * @param actionEvent
     */
    public void modifyAppointmentCancelButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/AppointmentScreenView.fxml", "Appointments");
    }

    /**
     * modifyAppointmentTitleTextFieldAction method for the appointment's title.
     *
     * @param actionEvent
     */
    public void modifyAppointmentTitleAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentTypeTextFieldAction method for the appointment's type.
     *
     * @param actionEvent
     */
    public void modifyAppointmentTypeAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentDescriptionTextFieldAction method for the appointment's description.
     *
     * @param actionEvent
     */
    public void modifyAppointmentDescriptionAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentLocationTextFieldAction method for the appointment's location.
     *
     * @param actionEvent
     */
    public void modifyAppointmentLocationAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentStartDateDatePickerAction method for the appointment's start date picker.
     *
     * @param actionEvent
     */
    public void modifyAppointmentStartDateAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentEndDateDatePickerAction method for the appointment's end date picker.
     *
     * @param actionEvent
     */
    public void modifyAppointmentEndDateAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentStartTimeAction method for appointment's start time.
     *
     * @param actionEvent
     */
    public void modifyAppointmentStartTimeAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentContactAction method for appointment's contact.
     *
     * @param actionEvent
     */
    public void modifyAppointmentContactAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentCustomerIDAction method for appointment's customer ID.
     *
     * @param actionEvent
     */
    public void modifyAppointmentCustomerIDAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentEndTimeAction method for appointment's end time.
     *
     * @param actionEvent
     */
    public void modifyAppointmentEndTimeAction(ActionEvent actionEvent) {
    }
}