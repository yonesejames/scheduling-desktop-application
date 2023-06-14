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

/**
 * Controller class that edits the customers in the application.
 *
 * @author Yonese James
 */
public class ModifyCustomerController implements Initializable {
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
     * FXML combo box variable for the customer's country.
     */
    @FXML
    public ComboBox modifyCustomerCountryComboBox;

    /**
     * FXML combo box variable for the customer's state and province.
     */
    @FXML
    public ComboBox modifyCustomerDivisionComboBox;

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

    /**
     *  Customer that has been selected when user clicks on customer.
     */
    Customer selectedCustomer;

    public void modifyCustomerCountryAction() throws Exception {
        modifyCustomerDivisionComboBox.setItems(FirstLevelDivisionDAO.getDivision(String.valueOf(modifyCustomerCountryComboBox.getValue())));
        modifyCustomerDivisionComboBox.getSelectionModel().select(selectedCustomer.getDivisionName());
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
     * modifyCustomerSaveButtonAction method to save the modified customer.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void modifyCustomerSaveButtonAction(ActionEvent actionEvent) throws Exception {
        int customerID = Integer.parseInt(modifyCustomerIDLabel.getText());
        String customerName = modifyCustomerNameTextField.getText();
        String customerAddress = modifyCustomerAddressTextField.getText();
        String customerPhone = modifyCustomerPhoneNumberTextField.getText();
        String customerCountry = String.valueOf(modifyCustomerCountryComboBox.getValue());
        String customerDivisionName = String.valueOf(modifyCustomerDivisionComboBox.getValue());
        int customerDivisionID = FirstLevelDivisionDAO.getDivisionID(customerDivisionName);
        String customerPostalCode = modifyCustomerPostalCodeTextField.getText();

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

            int customerUpdated = CustomerDAO.updateCustomer(customerName, customerAddress, customerPostalCode, customerPhone,
                    customerDivisionID, customerID);

            if (customerUpdated != -1) {
                alertMessage("Confirmation", "CUSTOMER HAS BEEN UPDATED");
                showScreen(actionEvent, "view/CustomerScreenView.fxml", "Customers");
            } else {
                alertMessage("Error", "CUSTOMER HAS NOT BEEN UPDATED");
            }
        }
    }

    /**
     * modifyCustomerCancelButtonAction method revert back to the customer screen.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void modifyCustomerCancelButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/CustomerScreenView.fxml", "Customers");
    }

    /**
     * modifyCustomerNameAction method for the customer's name.
     *
     * @param actionEvent
     */
    public void modifyCustomerNameAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerAddressAction method for the customer's address.
     *
     * @param actionEvent
     */
    public void modifyCustomerAddressAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerPhoneAction method for the customer's phone number.
     *
     * @param actionEvent
     */
    public void modifyCustomerPhoneAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerDivisionAction method for the customer's division.
     *
     * @param actionEvent
     */
    public void modifyCustomerDivisionAction(ActionEvent actionEvent) {
    }

    /**
     * modifyCustomerPostalCodeAction method for the customer's postal code.
     *
     * @param actionEvent
     */
    public void modifyCustomerPostalCodeAction(ActionEvent actionEvent) {
    }

}