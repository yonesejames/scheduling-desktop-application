package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.Main;
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
import java.util.Optional;
import java.util.ResourceBundle;
import static com.example.schedulingdesktopapplication.DAO.CustomerDAO.*;

/**
 * Controller class that views customers in the application.
 *
 * @author Yonese James
 */
public class CustomerScreenController implements Initializable {
    /**
     *  FXML table view variable for the customers.
     */
    @FXML
    public TableView<Customer> customerTableView;

    /**
     *  FXML table column variable for the customer's IDs.
     */
    @FXML
    public TableColumn<Customer, Integer> customerTableColumnID;

    /**
     *  FXML table column variable for the customer's names.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnName;

    /**
     *  FXML table column variable for the customer's addresses.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnAddress;

    /**
     *  FXML table column variable for the customer's phone numbers.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnPhoneNumber;

    /**
     *  FXML table column variable for the customer's state and province.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnDivision;

    /**
     *  FXML table column variable for the customer's postal code.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnPostalCode;

    /**
     *  FXML reports button variable to view reports.
     */
    @FXML
    public Button customerReportsButton;

    /**
     *  FXML add button variable to add a customer.
     */
    @FXML
    public Button customerAddButton;

    /**
     *  FXML modify button variable to modify the selected customer.
     */
    @FXML
    public Button customerModifyButton;

    /**
     *  FXML delete button variable to delete the selected customer.
     */
    @FXML
    public Button customerDeleteButton;

    /**
     *  FXML logout button variable to exit the application.
     */
    @FXML
    public Button customerLogoutButton;

    /**
     *  FXML label variable for the customer's timezone.
     */
    @FXML
    public Label customerTimeZone;

    /**
     *  FXML back button variable to go to the main menu of the application.
     */
    @FXML
    public Button customersBackButton;

    /**
     *  List of all customers.
     */
    private ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

    /**
     *  Customer that has been selected when user clicks on customer.
     */
    private static Customer selectedCustomer;


    /**
     * Initialize method for the CustomerScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allCustomers = getAllCustomers();
            customerTableView.setItems(allCustomers);
            customerTableColumnID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            customerTableColumnName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            customerTableColumnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            customerTableColumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
            customerTableColumnDivision.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
            customerTableColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        } catch (Exception e) {
            e.printStackTrace(); }
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
     * customerReportsButtonAction method to go to the reports page and view reports.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void customerReportsButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/ReportScreenView.fxml", "Reports");
    }

    /**
     * customerAddButtonAction method to go to the add customer page and add a customer.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void customerAddButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/AddCustomerView.fxml", "Add Customer");
    }

    /**
     * customerModifyButtonAction method to go to the modify customer page and modify the customer.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void customerModifyButtonAction(ActionEvent actionEvent) throws IOException {
        selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null)
        {
            alertMessage("Error", "NO CUSTOMER WAS SELECTED");
        }
        else
        {
            showScreen(actionEvent, "view/ModifyCustomerView.fxml", "Modify Customer");
        }
    }

    /**
     * getSelectedCustomer method to return the selectedCustomer.
     *
     * @return the selectedCustomer.
     */
    public static Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    /**
     * customerDeleteButtonAction method to delete a selected customer.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void customerDeleteButtonAction(ActionEvent actionEvent) throws Exception {
        selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null)
        {
            alertMessage("Error", "NO CUSTOMER WAS SELECTED");
        }
        else
        {
            alertMessage("Confirmation", "PLEASE CONFIRM IF YOU WOULD LIKE TO DELETE THIS CUSTOMER");
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("CONFIRMATION");
            confirmationAlert.setContentText("PLEASE CONFIRM IF YOU WOULD LIKE TO DELETE THIS CUSTOMER");
            Optional<ButtonType> confirmationButton = confirmationAlert.showAndWait();

            if (confirmationButton.isPresent() && confirmationButton.get() == ButtonType.OK)
            {
                deleteCustomer(selectedCustomer.getCustomerID());
                allCustomers = getAllCustomers();
                customerTableView.setItems(allCustomers);
                customerTableColumnID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
                customerTableColumnName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
                customerTableColumnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
                customerTableColumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
                customerTableColumnDivision.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
                customerTableColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            }
            else
            {
                alertMessage("Error", "CUSTOMER WAS NOT DELETED");
            }
        }
    }

    /**
     * customerBackButtonAction method to go to the main menu of the application.
     *
     * @throws Exception
     * @param actionEvent
     */
    public void customerBackButtonAction(ActionEvent actionEvent) throws IOException {
        showScreen(actionEvent, "view/MainScreenView.fxml", "Scheduling Desktop Application");
    }

    /**
     * customerLogoutButtonAction method to logout of the application.
     *
     * @param actionEvent
     */
    public void customerLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}