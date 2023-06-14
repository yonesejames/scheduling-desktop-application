package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.AppointmentDAO;
import com.example.schedulingdesktopapplication.DAO.ContactDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Appointment;
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
import java.sql.Timestamp;
import java.time.*;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import static com.example.schedulingdesktopapplication.DAO.ContactDAO.getContactID;
import static com.example.schedulingdesktopapplication.DAO.UserDAO.getUserID;
import static com.example.schedulingdesktopapplication.model.LoginActivity.getZoneId;

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
     *  List of all conflicted appointments.
     */
    private ObservableList<Appointment> conflictedAppointments = FXCollections.observableArrayList();

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

            /**
             * Lambda Expression takes an argument picker and returns an instance of DateCell that
             * represents a cell within the date picker's day cells while disabling days previous from today.
             */
            addAppointmentStartDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));

            /**
             * Lambda Expression takes an argument picker and returns an instance of DateCell that
             * represents a cell within the date picker's day cells while disabling days previous from today.
             */
            addAppointmentEndDateDatePicker.setDayCellFactory((picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0 );
                }
            }));

//            for(int i = 0; i < 24; i++) {
//                addAppointmentStartTimeComboBox.getItems().add(LocalTime.of(i, 0));
//                addAppointmentEndTimeComboBox.getItems().add(LocalTime.of(i, 0));
//            }
            /**
             * Lambda Expression that generates a stream of integers from 0 to 23, representing the hours in a day.
             * Then, the forEach operation is used to iterate over each integer value (i), and within the lambda body,
             * the addAppointmentStartTimeComboBox and addAppointmentEndTimeComboBox are populated
             * with LocalTime values using LocalTime.of(i, 0).
             */
            IntStream.range(0, 24)
                    .forEach(i -> {
                        addAppointmentStartTimeComboBox.getItems().add(LocalTime.of(i, 0));
                        addAppointmentEndTimeComboBox.getItems().add(LocalTime.of(i, 0));
                    });
            addAppointmentCustomerIDComboBox.setItems(CustomerDAO.getCustomerIDs());
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
     * addAppointmentSaveAction method to save appointment.
     *
     * @param actionEvent for save.
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

        LocalDateTime appointmentStartDateTime = LocalDateTime.of(appointmentStartDate, appointmentStartTime);
        LocalDateTime appointmentEndDateTime = LocalDateTime.of(appointmentEndDate, appointmentEndTime);


        ZonedDateTime appointmentZoneStartDateTime = ZonedDateTime.of(appointmentStartDateTime, getZoneId());
        ZonedDateTime appointmentZoneEndDateTime = ZonedDateTime.of(appointmentEndDateTime, getZoneId());
        ZonedDateTime startBusinessHoursEST = ZonedDateTime.of(appointmentStartDate, LocalTime.of(8,0),
                ZoneId.of("America/New_York"));
        ZonedDateTime endBusinessHoursEST = ZonedDateTime.of(appointmentEndDate,LocalTime.of(22, 0),
                ZoneId.of("America/New_York"));


        conflictedAppointments = AppointmentDAO.getConflictedAppointments(Timestamp.valueOf(appointmentStartDateTime),
                appointmentCustomerID);

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
        else if (!conflictedAppointments.isEmpty()) {
            alertMessage("Error", "CONFLICTED APPOINTMENT");
        }
        else {

            String createdBy = String.valueOf(LoginScreenController.username);

            int appointmentAdded = AppointmentDAO.insertAppointment(appointmentTitle, appointmentDescription, appointmentLocation,
                    appointmentType, Timestamp.valueOf(appointmentStartDateTime), Timestamp.valueOf(appointmentEndDateTime),
                    createdBy, createdBy, appointmentContactID, userID, appointmentCustomerID);

            if (appointmentAdded != -1) {
                alertMessage("Confirmation", "APPOINTMENT HAS BEEN ADDED");
                showScreen(actionEvent, "view/AppointmentScreenView.fxml", "Appointments");
            } else {
                alertMessage("Error", "APPOINTMENT HAS NOT BEEN ADDED");
            }
        }
    }

    /**
     * addAppointmentCancelAction method to cancel appointment.
     *
     * @param actionEvent for cancel.
     */
    public void addAppointmentCancelAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/AppointmentScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * addAppointmentTitleAction method for the appointment's title.
     *
     * @param actionEvent for title.
     */
    public void addAppointmentTitleAction(ActionEvent actionEvent) {
    }

    /**
     * addAppointmentTypeAction method for the appointment's type.
     *
     * @param actionEvent for type.
     */
    public void addAppointmentTypeAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentDescriptionAction method for the appointment's description.
     *
     * @param actionEvent for description.
     */
    public void addAppointmentDescriptionAction(ActionEvent actionEvent) {
    }

    /**
     * addAppointmentLocationAction method for the appointment's location.
     *
     * @param actionEvent for location.
     */
    public void addAppointmentLocationAction(ActionEvent actionEvent) {
    }

    /**
     * addAppointmentStartTime method for appointment's start time.
     *
     * @param actionEvent for start time.
     */
    public void addAppointmentStartTime(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentEndTimeAction method for appointment's end time.
     *
     * @param actionEvent for end time.
     */
    public void addAppointmentEndTimeAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentStartDateDatePickerAction method for the appointment's start date picker.
     *
     * @param actionEvent for start date.
     */
    public void addAppointmentStartDateAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentEndDateDatePickerAction method for the appointment's end date picker.
     *
     * @param actionEvent for end date.
     */
    public void addAppointmentEndDateAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentContactAction method for appointment's contact.
     *
     * @param actionEvent for contact.
     */
    public void addAppointmentContactAction(ActionEvent actionEvent) {
    }

    /**
     * addAppointmentCustomerIDAction method for appointment's ID.
     *
     * @param actionEvent for customerID.
     */
    public void addAppointmentCustomerIDAction(ActionEvent actionEvent) {
    }
}
