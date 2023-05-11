package com.example.schedulingdesktopapplication.controller;
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
    public TextField modifyCustomerIDTextField;

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

    /**
     * Initialize method for the ModifyCustomercontroller to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCustomer = CustomerScreenController.getSelectedCustomer();
        modifyCustomerIDTextField.setText(String.valueOf(selectedCustomer.getCustomerID()));
        modifyCustomerNameTextField.setText(String.valueOf(selectedCustomer.getCustomerName()));
        modifyCustomerAddressTextField.setText(String.valueOf(selectedCustomer.getAddress()));
        modifyCustomerPhoneNumberTextField.setText(String.valueOf(selectedCustomer.getPhone()));
//        get combobox option for country
//        get combobox option for state/province
        modifyCustomerPostalCodeTextField.setText(String.valueOf(selectedCustomer.getPostalCode()));
    }

    /**
     * modifyCustomerSaveButtonAction method to save the modified customer.
     *
     * @param actionEvent
     */
    public void modifyCustomerSaveButtonAction(ActionEvent actionEvent) {
        try {
            int customerID = selectedCustomer.getCustomerID();
            String customerName = selectedCustomer.getCustomerName();
            String customerAddress = selectedCustomer.getAddress();
            String customerPhone = selectedCustomer.getPhone();
//        get combobox option for country
//        get combobox option for state/province
            String customerPostalCode = selectedCustomer.getPostalCode();

//            updateCustomer(customerName, customerAddress, customerPostalCode, customerPhone, );

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/CustomerScreenView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Customers");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("WARNING");
            errorAlert.setContentText("MUST HAVE INPUT FOR ALL VALUES");
            errorAlert.showAndWait();
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