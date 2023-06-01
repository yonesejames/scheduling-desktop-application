package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.DAO.CountryDAO;
import com.example.schedulingdesktopapplication.DAO.CustomerDAO;
import com.example.schedulingdesktopapplication.DAO.FirstLevelDivisionDAO;
import com.example.schedulingdesktopapplication.Main;
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
import java.util.ResourceBundle;

import static com.example.schedulingdesktopapplication.DAO.CustomerDAO.updateCustomer;

/**
 * Controller class that edits the customers in the application.
 *
 * @author Yonese James
 */
public class ModifyCustomercontroller implements Initializable {
    /**
     * FXML text field variable for the customer's ID.
     */
    @FXML
    public Label modifyCustomerIDLabel;

    /**
     * FXML text field variable for the customer's name.
     */
    @FXML
    public TextField modifyCustomerNameTextField;

    /**
     * FXML text field variable for the customer's address.
     */
    @FXML
    public TextField modifyCustomerAddressTextField;

    /**
     * FXML text field variable for the customer's phone number.
     */
    @FXML
    public TextField modifyCustomerPhoneNumberTextField;

    /**
     * FXML text field variable for the customer's postal code.
     */
    @FXML
    public TextField modifyCustomerPostalCodeTextField;

    /**
     * FXML choice box variable for the customer's country.
     */
    @FXML
    public ComboBox modifyCustomerCountryComboBox;

    /**
     * FXML choice box variable for the customer's state and province.
     */
    @FXML
    public ComboBox modifyCustomerStateAndProvinceComboBox;

    /**
     *  FXML save button variable to save the customer.
     */
    @FXML
    public Button modifyCustomerSaveButton;

    /**
     *  FXML cancel button variable to revert back to the main screen.
     */
    @FXML
    public Button modifyCustomerCancelButton;

    Customer selectedCustomer;

    public void modifyCustomerCountryAction() throws Exception {
        modifyCustomerStateAndProvinceComboBox.setItems(FirstLevelDivisionDAO.getDivision(String.valueOf(modifyCustomerCountryComboBox.getValue())));
        modifyCustomerStateAndProvinceComboBox.getSelectionModel().select(selectedCustomer.getDivisionName());
    }

    /**
     * Initialize method for the ModifyCustomercontroller to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCustomer = CustomerScreenController.getSelectedCustomer();
        modifyCustomerIDLabel.setText(String.valueOf(selectedCustomer.getCustomerID()));
        modifyCustomerNameTextField.setText(String.valueOf(selectedCustomer.getCustomerName()));
        modifyCustomerAddressTextField.setText(String.valueOf(selectedCustomer.getAddress()));
        modifyCustomerPhoneNumberTextField.setText(String.valueOf(selectedCustomer.getPhone()));
        try {
            modifyCustomerCountryComboBox.setItems(CountryDAO.getAllCountries());
            modifyCustomerCountryComboBox.getSelectionModel().select(selectedCustomer.getCountry());
            modifyCustomerCountryAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        modifyCustomerPostalCodeTextField.setText(String.valueOf(selectedCustomer.getPostalCode()));
    }

    /**
     * modifyCustomerSaveButtonAction method to save the modified customer.
     *
     * @param actionEvent
     */
    public void modifyCustomerSaveButtonAction(ActionEvent actionEvent) throws Exception {
        int customerID = Integer.parseInt(modifyCustomerIDLabel.getText());
        String customerName = modifyCustomerNameTextField.getText();
        String customerAddress = modifyCustomerAddressTextField.getText();
        String customerPhone = modifyCustomerPhoneNumberTextField.getText();
        String customerCountry = String.valueOf(modifyCustomerCountryComboBox.getValue());
        String customerDivisionName = String.valueOf(modifyCustomerStateAndProvinceComboBox.getValue());
        int customerDivisionID = FirstLevelDivisionDAO.getDivisionID(customerDivisionName);
        String customerPostalCode = modifyCustomerPostalCodeTextField.getText();

        if (customerName.isBlank() || customerAddress.isBlank() || customerPhone.isBlank() || customerCountry.isBlank() || customerDivisionName.isBlank() ||
                customerPostalCode.isBlank()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("ERROR");
            errorAlert.setContentText("PLEASE ENTER VALUE FOR EACH FIELD");
            errorAlert.showAndWait();
            return;
        }

        int customerAdded = CustomerDAO.updateCustomer(customerName, customerAddress, customerPostalCode, customerPhone,
                customerDivisionID, customerID);


        if (customerAdded != -1) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("CONFIRM");
            confirmationAlert.setContentText("CUSTOMER HAS BEEN ADDED");
            confirmationAlert.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Customers");
            stage.setScene(scene);
            stage.show();
        } else {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("WARNING");
            warningAlert.setContentText("CUSTOMER HAS NOT BEEN ADDED");
            warningAlert.showAndWait();
            return;
        }


    }

    /**
     * modifyCustomerCancelButtonAction method revert back to the customer screen.
     *
     * @param actionEvent
     */
    public void modifyCustomerCancelButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * modifyCustomerIDTextFieldAction method for the customer's ID.
     *
     * @param actionEvent
     */
    public void modifyCustomerIDTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerNameTextFieldAction method for the customer's name.
     *
     * @param actionEvent
     */
    public void modifyCustomerNameTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerAddressTextFieldAction method for the customer's address.
     *
     * @param actionEvent
     */
    public void modifyCustomerAddressTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerPhoneNumberTextFieldAction method for the customer's phone number.
     *
     * @param actionEvent
     */
    public void modifyCustomerPhoneNumberTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerPostalCodeTextFieldAction method for the customer's postal code.
     *
     * @param actionEvent
     */
    public void modifyCustomerPostalCodeTextFieldAction(ActionEvent actionEvent) {
    }
}