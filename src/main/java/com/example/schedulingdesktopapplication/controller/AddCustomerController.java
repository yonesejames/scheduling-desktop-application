package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.CountryDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.DAO.FirstLevelDivisionDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Country;
import com.example.schedulingdesktopapplication.model.FirstLevelDivision;
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
import java.util.ResourceBundle;

/**
 * Controller class that adds customers in the application.
 *
 * @author Yonese James
 */
public class AddCustomerController implements Initializable {
    /**
     * FXML text field variable for the customer's ID.
     */
    @FXML
    public Label addCustomerIDLabel;

    /**
     * FXML text field variable for the customer's name.
     */
    @FXML
    public TextField addCustomerNameTextField;

    /**
     * FXML text field variable for the customer's address.
     */
    @FXML
    public TextField addCustomerAddressTextField;

    /**
     * FXML text field variable for the customer's phone number.
     */
    @FXML
    public TextField addCustomerPhoneNumberTextField;

    /**
     * FXML text field variable for the customer's postal code.
     */
    @FXML
    public TextField addCustomerPostalCodeTextField;

    /**
     * FXML combo box variable for the customer's country.
     */
    @FXML
    public ComboBox<Country> addCustomerCountryComboBox;

    /**
     * FXML combo box variable for the customer's state or province.
     */
    @FXML
    public ComboBox<FirstLevelDivision> addCustomerDivisionComboBox;

    /**
     * FXML button variable to save the customer.
     */
    @FXML
    public Button addCustomerSaveButton;

    /**
     *  FXML cancel button variable to revert back to the main screen.
     */
    @FXML
    public Button addCustomerCancelButton;


    /**
     * addCustomerCountryAction method that set items to the division combo box.
     *
     * @throws Exception when country does not display.
     */
    public void addCustomerCountryAction() throws Exception {
        addCustomerDivisionComboBox.setItems(FirstLevelDivisionDAO.getDivision(String.valueOf(addCustomerCountryComboBox.getValue())));
    }

    /**
     * Initialize method for the AddCustomerController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addCustomerCountryComboBox.setItems(CountryDAO.getAllCountries());
            addCustomerCountryComboBox.getSelectionModel().selectFirst();
            addCustomerCountryAction();
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
     * addCustomerSaveAction method to save customer.
     *
     * @throws Exception when customer does not save.
     * @param actionEvent for save.
     */
    public void addCustomerSaveAction(ActionEvent actionEvent) throws Exception {
        String customerName = addCustomerNameTextField.getText();
        String customerAddress = addCustomerAddressTextField.getText();
        String customerPhone = addCustomerPhoneNumberTextField.getText();
        String customerCountry = String.valueOf(addCustomerCountryComboBox.getValue());
        String customerDivisionName = String.valueOf(addCustomerDivisionComboBox.getValue());
        int customerDivisionID = FirstLevelDivisionDAO.getDivisionID(customerDivisionName);
        String customerPostalCode = addCustomerPostalCodeTextField.getText();

        if (customerName.isBlank()) {
            alertMessage("Error", "PLEASE ENTER NAME");
        }
        else if (customerAddress.isBlank()) {
            alertMessage("Error", "PLEASE ENTER ADDRESS");
        }
        else if (customerPhone.isBlank()) {
            alertMessage("Error", "PLEASE ENTER PHONE NUMBER");
        }
        else if (customerCountry.isBlank()) {
            alertMessage("Error", "PLEASE SELECT COUNTRY");
        }
        else if (customerDivisionName.isBlank()) {
            alertMessage("Error", "PLEASE SELECT STATE OR PROVINCE");
        }
        else if (customerPostalCode.isBlank()) {
            alertMessage("Error", "PLEASE ENTER POSTAL CODE");
        }
        else {

            int customerAdded = CustomerDAO.insertCustomer(customerName, customerAddress, customerPostalCode, customerPhone,
                    customerDivisionID);

            if (customerAdded != -1) {
                alertMessage("Confirmation", "CUSTOMER HAS BEEN ADDED");
                showScreen(actionEvent, "view/CustomerScreenView.fxml", "Customers");
            } else {
                alertMessage("Error", "CUSTOMER HAS NOT BEEN ADDED");
            }
        }
    }

    /**
     * addCustomerCancelAction method to revert back to the customers screen.
     *
     * @throws IOException when customer does not cancel.
     * @param actionEvent for cancel.
     */
    public void addCustomerCancelAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/CustomerScreenView.fxml", "Customers");
    }

    /**
     * addCustomerNameAction method for the customer's name.
     *
     * @param actionEvent for name.
     */
    public void addCustomerNameAction(ActionEvent actionEvent) {
    }

    /**
     * addCustomerAddressAction method for the customer's address.
     *
     * @param actionEvent for address.
     */
    public void addCustomerAddressAction(ActionEvent actionEvent) {
    }

    /**
     * addCustomerPhoneNumberAction method for the customer's phone number.
     *
     * @param actionEvent for phone number.
     */
    public void addCustomerPhoneNumberAction(ActionEvent actionEvent) {
    }

    /**
     * addCustomerDivisionAction method for the customer's division.
     *
     * @param actionEvent for division.
     */
    public void addCustomerDivisionAction(ActionEvent actionEvent) {
    }

    /**
     * addCustomerPostalCodeAction method for the customer's postal code.
     *
     * @param actionEvent for postal code.
     */
    public void addCustomerPostalCodeAction(ActionEvent actionEvent) {
    }
}
