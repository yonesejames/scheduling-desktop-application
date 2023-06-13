package com.example.schedulingdesktopapplication.controller;
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
import java.time.LocalDate;
import java.time.LocalTime;
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
    public ComboBox modifyAppointmentCustomerIDComboBox;

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
        System.out.println(selectedAppointment.getUserID());
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        modifyAppointmentContactComboBox.getSelectionModel().select(selectedAppointment.getContactID());
        modifyAppointmentCustomerIDComboBox.getSelectionModel().select(selectedAppointment.getCustomerID());

    }

    /**
     * modifyAppointmentSaveButtonAction method to save the modified appointment.
     *
     * @param actionEvent
     */
    public void modifyAppointmentSaveButtonAction(ActionEvent actionEvent) {
    }

    /**
     * modifyAppointmentCancelButtonAction method to revert back to the appointment screen.
     *
     * @param actionEvent
     */
    public void modifyAppointmentCancelButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/AppointmentScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
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