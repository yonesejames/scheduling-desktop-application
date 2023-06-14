package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.AppointmentDAO;
import com.example.schedulingdesktopapplication.DAO.ContactDAO;
import com.example.schedulingdesktopapplication.DAO.ReportDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Appointment;
import com.example.schedulingdesktopapplication.model.Report;
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
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Controller class that views the reports in the application.
 *
 * @author Yonese James
 */
public class ReportScreenController implements Initializable {
    /**
     *  FXML table view variable for all of the reports.
     */
    @FXML
    public TableView<Appointment> reportsMainTableView;

    /**
     *  FXML table column variable for the report's IDs.
     */
    @FXML
    public TableColumn<Appointment, Integer> reportsTableColumnID;

    /**
     *  FXML table column variable for the report's title.
     */
    @FXML
    public TableColumn<Appointment, String> reportsTableColumnTitle;

    /**
     *  FXML table column variable for the report's description.
     */
    @FXML
    public TableColumn<Appointment, String> reportsTableColumnDescription;

    /**
     *  FXML table column variable for the report's type.
     */
    @FXML
    public TableColumn<Appointment, String> reportsTableColumnType;

    /**
     *  FXML table column variable for the report's location.
     */
    @FXML
    public TableColumn<Appointment, String> reportsTableColumnLocation;

    /**
     *  FXML table column variable for the report's start date and time.
     */
    @FXML
    public TableColumn<Appointment, Date> reportsTableColumnStartDateAndTime;

    /**
     *  FXML table column variable for the report's end date and time.
     */
    @FXML
    public TableColumn<Appointment, Date> reportsTableColumnEndDateAndTime;

    /**
     *  FXML table column variable for the report's customer IDs.
     */
    @FXML
    public TableColumn<Appointment, Integer> reportsTableColumnCustomerID;

    /**
     * FXML choice box variable to select a contact for the report.
     */
    @FXML
    public ComboBox reportsSelectContactComboBox;

    /**
     *  FXML back button variable to revert to the main screen.
     */
    @FXML
    public Button reportsBackButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button reportsLogoutButton;

    /**
     *  FXML table view variable for the appointment reports.
     */
    @FXML
    public TableView reportsLeftTableView;

    /**
     *  FXML table column variable for the appointment report's month.
     */
    @FXML
    public TableColumn<Report, String> reportsColumnAppointmentMonth;

    /**
     *  FXML table column variable for the appointment report's type.
     */
    @FXML
    public TableColumn<Report, String> reportsColumnAppointmentType;

    /**
     *  FXML table column variable for the appointment report's total months.
     */
    @FXML
    public TableColumn<Report, Integer> reportsColumnTotalMonths;

    /**
     *  FXML table column variable for the appointment report's total types.
     */
    @FXML
    public TableColumn<Report, Integer> reportsColumnTotalTypes;

    /**
     *  FXML table view variable for the division reports.
     */
    @FXML
    public TableView reportsRightTableView;

    /**
     *  FXML table column variable for the division report's name.
     */
    @FXML
    public TableColumn reportsColumnDivisionName;

    /**
     *  FXML table column variable for the division report's total customers.
     */
    @FXML
    public TableColumn reportsColumnTotalCustomers;

    /**
     *  List of all appointments.
     */
    private ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    /**
     *  List total appointments by month and type.
     */
    private ObservableList<Report> allMonthAndTypeReports = FXCollections.observableArrayList();

    /**
     *  List total customers by division name.
     */
    private ObservableList<Report> allCustomerByDivisionReports = FXCollections.observableArrayList();

    /**
     * reportsSelectContactAction method that changes the main tableview to show appointments based on contact selected.
     *
     * @param actionEvent
     * @throws Exception
     */
    public void reportsSelectContactAction(ActionEvent actionEvent) throws Exception {
        String contactName = String.valueOf(reportsSelectContactComboBox.getSelectionModel().getSelectedItem());
        allAppointments = AppointmentDAO.getAppointmentsByContact(contactName);
        reportsMainTableView.setItems(allAppointments);
        reportsTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        reportsTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        reportsColumnAppointmentType.setCellValueFactory(new PropertyValueFactory<>("type"));
        reportsTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        reportsTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        reportsTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        reportsTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        reportsTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    }

    /**
     * Initialize method for the ReportScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            reportsSelectContactComboBox.setItems(ContactDAO.getContactNames());
            reportsSelectContactComboBox.getSelectionModel().selectFirst();
            String contactName = reportsSelectContactComboBox.getSelectionModel().getSelectedItem().toString();
            allAppointments = AppointmentDAO.getAppointmentsByContact(contactName);
            reportsMainTableView.setItems(allAppointments);
            reportsTableColumnID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            reportsTableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            reportsColumnAppointmentType.setCellValueFactory(new PropertyValueFactory<>("type"));
            reportsTableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            reportsTableColumnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
            reportsTableColumnStartDateAndTime.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
            reportsTableColumnEndDateAndTime.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
            reportsTableColumnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));

            allMonthAndTypeReports = ReportDAO.getAllAppointmentsByMonthAndType();
            reportsLeftTableView.setItems(allMonthAndTypeReports);
            reportsColumnAppointmentMonth.setCellValueFactory(new PropertyValueFactory<>("appointmentMonth"));
            reportsColumnTotalMonths.setCellValueFactory(new PropertyValueFactory<>("appointmentMonthTotal"));
            reportsColumnAppointmentType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
            reportsColumnTotalTypes.setCellValueFactory(new PropertyValueFactory<>("appointmentTypeTotal"));

            allCustomerByDivisionReports = ReportDAO.getTotalCustomersByDivision();
            reportsRightTableView.setItems(allCustomerByDivisionReports);
            reportsColumnDivisionName.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
            reportsColumnTotalCustomers.setCellValueFactory(new PropertyValueFactory<>("customerTotal"));

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
            case "Information":
                Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
                informationAlert.setTitle("INFORMATION");
                informationAlert.setContentText(alertText);
                informationAlert.showAndWait();
                break;
        }
    }

    /**
     * reportsBackButtonAction method to go back to main screen.
     *
     * @param actionEvent
     */
    public void reportsBackButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/MainScreenView.fxml", "Scheduling Desktop Application");
    }

    /**
     * reportsLogoutButtonAction method to log out of the application.
     *
     * @param actionEvent
     */
    public void reportsLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }

}
