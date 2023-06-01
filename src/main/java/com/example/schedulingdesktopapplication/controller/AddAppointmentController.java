package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.ContactDAO;
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
import java.time.format.DateTimeFormatter;
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
    public ComboBox addAppointmentStartTimeComboBox;

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
     * FXML combo box variable for the appointment's customer ID.
     */
    @FXML
    public Label addAppointmentCustomerIDLabel;

    /**
     * FXML combo box variable for the appointment's end time.
     */
    @FXML
    public ComboBox addAppointmentEndTimeComboBox;

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
     *  FXML cancel button variable to revert back to the main screen.
     */
    @FXML
    public Button addAppointmentCancelButton;

    private final ObservableList<String> appointmentStartTimes = FXCollections.observableArrayList();

    private final ObservableList<String> appointmentEndTimes = FXCollections.observableArrayList();

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Initialize method for the AddAppointmentController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
//            addAppointmentStartDateDatePicker.setDayCellFactory(datePicker -> new DateCell());
            addAppointmentContactComboBox.setItems(ContactDAO.getContactNames());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAppointmentStartTimes() {


    }

    public void addAppointmentEndTimes() {

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
