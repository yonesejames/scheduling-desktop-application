package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Appointment;
import com.example.schedulingdesktopapplication.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import static com.example.schedulingdesktopapplication.DAO.AppointmentDAO.*;

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
    public TableView<Appointment> appointmentTableView;

    /**
     *  FXML table column variable for the appointment's IDs.
     */
    @FXML
    public TableColumn<Appointment, Integer> appointmentTableColumnID;

    /**
     *  FXML table column variable for the appointment's titles.
     */
    @FXML
    public TableColumn<Appointment, String> appointmentTableColumnTitle;

    /**
     *  FXML table column variable for the appointment's types.
     */
    @FXML
    public TableColumn<Appointment, String> appointmentTableColumnType;

    /**
     *  FXML table column variable for the appointment's description.
     */
    @FXML
    public TableColumn<Appointment, String> appointmentTableColumnDescription;

    /**
     *  FXML table column variable for the appointment's location.
     */
    @FXML
    public TableColumn<Appointment, String> appointmentTableColumnLocation;

    /**
     *  FXML table column variable for the appointment's start date and time.
     */
    @FXML
    public TableColumn<Appointment, Date> appointmentTableColumnStartDateAndTime;

    /**
     *  FXML table column variable for the appointment's end date and time.
     */
    @FXML
    public TableColumn<Appointment, Date> appointmentTableColumnEndDateAndTime;

    /**
     *  FXML table column variable for the appointment's contact.
     */
    @FXML
    public TableColumn<Appointment, String> appointmentTableColumnContact;

    /**
     *  FXML table column variable for the appointment's customer IDs.
     */
    @FXML
    public TableColumn<Appointment, Integer> appointmentTableColumnCustomerID;

    /**
     *  FXML table column variable for the appointment's user IDs.
     */
    @FXML
    public TableColumn<Appointment, Integer> appointmentTableColumnUserID;

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
     * FXML toggle variable for the appointment's radio buttons: week, month, or all.
     */
    @FXML
    public ToggleGroup weekMonthOrAll;

    /**
     *  List of all appointments.
     */
    private ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    /**
     *  Appointment that has been selected when user clicks on appointment.
     */
    private static Appointment selectedAppointment;

    /**
     * Initialize method for the AppointmentScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allAppointments = getAllAppointments();
            appointmentTableView.setItems(allAppointments);
            appointmentTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            appointmentTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            appointmentTableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            appointmentTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            appointmentTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
            appointmentTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
            appointmentTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
            appointmentTableColumnContact.setCellValueFactory(new PropertyValueFactory<>("contactName"));
            appointmentTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            appointmentTableColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));

            weekMonthOrAll.selectToggle(allAppointmentsRadioButton);

            appointmentTimeZone.setText(String.valueOf(ZoneId.systemDefault()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * appointmentCurrentWeekRadioButtonAction method to view current week of appointments.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void appointmentCurrentWeekRadioButtonAction(ActionEvent actionEvent) throws Exception {
        ObservableList<Appointment> weeklyAppointments = getWeeklyAppointments();

        appointmentTableView.setItems(weeklyAppointments);
        appointmentTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentTableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentTableColumnContact.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        appointmentTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentTableColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));

        weekMonthOrAll.selectToggle(appointmentCurrentWeekRadioButton);

    }

    /**
     * appointmentCurrentMonthRadioButtonAction method to view current month of appointments.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void appointmentCurrentMonthRadioButtonAction(ActionEvent actionEvent) throws Exception {
        ObservableList<Appointment> monthlyAppointments = getMonthlyAppointments();

        appointmentTableView.setItems(monthlyAppointments);
        appointmentTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentTableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentTableColumnContact.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        appointmentTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentTableColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));

        weekMonthOrAll.selectToggle(appointmentCurrentMonthRadioButton);
    }

    /**
     * allAppointmentsRadioButtonAction method to view all appointments.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void allAppointmentsRadioButtonAction(ActionEvent actionEvent) {
        appointmentTableView.setItems(allAppointments);
        appointmentTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentTableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentTableColumnContact.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        appointmentTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentTableColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));

        weekMonthOrAll.selectToggle(allAppointmentsRadioButton);
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
     * appointmentReportsButtonAction method to go to the reports page and view reports.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void appointmentReportsButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/ReportScreenView.fxml", "Reports");
    }

    /**
     * appointmentModifyButtonAction method to modify a selected appointment.
     *
     * @param actionEvent
     */
    public void appointmentModifyButtonAction(ActionEvent actionEvent) throws IOException {
        selectedAppointment = appointmentTableView.getSelectionModel().getSelectedItem();
        if (selectedAppointment == null)
        {
            alertMessage("Error", "NO APPOINTMENT WAS SELECTED");
        }
        else
        {
            showScreen(actionEvent, "view/ModifyAppointmentView.fxml", "Modify Appointment");
        }
    }

    /**
     * appointmentAddButtonAction method to add an appointment.
     *
     * @param actionEvent
     */
    public void appointmentAddButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/AddAppointmentView.fxml", "Add Appointment");
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
    public void appointmentsBackButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/MainScreenView.fxml", "Scheduling Desktop Application");
    }

    /**
     * allAppointmentsRadioButtonAction method to exit the application.
     *
     * @param actionEvent
     */
    public void appointmentsLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
