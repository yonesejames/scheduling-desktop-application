package com.example.schedulingdesktopapplication.controller;

import com.example.schedulingdesktopapplication.DAO.CountryDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.DAO.FirstLevelDivisionDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Country;
import com.example.schedulingdesktopapplication.model.Customer;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.schedulingdesktopapplication.DAO.JDBC.connection;

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
     * FXML choice box variable for the customer's country.
     */
    @FXML
    public ComboBox<Country> addCustomerCountryComboBox;

    /**
     * FXML choice box variable for the customer's state or province.
     */
    @FXML
    public ComboBox<FirstLevelDivision> addCustomerStateOrProvinceComboBox;

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

    public void addCustomerCountryAction() throws Exception {
        addCustomerStateOrProvinceComboBox.setItems(FirstLevelDivisionDAO.getDivision(String.valueOf(addCustomerCountryComboBox.getValue())));
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
     * addCustomerSaveAction method to save customer.
     *
     * @param actionEvent
     */
    public void addCustomerSaveAction(ActionEvent actionEvent) throws Exception {
//        int customerID = Integer.parseInt(addCustomerIDLabel.getText());
        String customerName = addCustomerNameTextField.getText();
        String customerAddress = addCustomerAddressTextField.getText();
        String customerPhone = addCustomerPhoneNumberTextField.getText();
        String customerCountry = String.valueOf(addCustomerCountryComboBox.getValue());
        String customerDivisionName = String.valueOf(addCustomerStateOrProvinceComboBox.getValue());
        int customerDivisionID = FirstLevelDivisionDAO.getDivisionID(customerDivisionName);
        String customerPostalCode = addCustomerPostalCodeTextField.getText();

        if (customerName.isBlank() || customerAddress.isBlank() || customerPhone.isBlank() || customerCountry.isBlank() || customerDivisionName.isBlank() ||
                customerPostalCode.isBlank()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("ERROR");
            errorAlert.setContentText("PLEASE ENTER VALUE FOR EACH FIELD");
            errorAlert.showAndWait();
            return;
        }

        int customerAdded = CustomerDAO.insertCustomer(customerName, customerAddress, customerPostalCode, customerPhone,
                customerDivisionID);


        if (customerAdded != -1) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("CONFIRM");
            confirmationAlert.setContentText("CUSTOMER HAS BEEN ADDED");
            confirmationAlert.showAndWait();

//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setTitle("Customers");
//            stage.setScene(scene);
//            stage.show();
        } else {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("WARNING");
            warningAlert.setContentText("CUSTOMER HAS NOT BEEN ADDED");
            warningAlert.showAndWait();
            return;
        }
    }

    /**
     * addCustomerCancelAction method to revert back to the main screen.
     *
     * @param actionEvent
     */
    public void addCustomerCancelAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
    }
}
