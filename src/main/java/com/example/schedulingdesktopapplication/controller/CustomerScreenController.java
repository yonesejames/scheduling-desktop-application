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
import static com.example.schedulingdesktopapplication.DAO.FirstLevelDivisionDAO.*;

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
    public TableColumn<Customer, String> customerTableColumnStateAndProvince;

    /**
     *  FXML table column variable for the customer's postal code.
     */
    @FXML
    public TableColumn<Customer, String> customerTableColumnPostalCode;

    /**
     * FXML radio button field variable to view current week of customers.
     */
    @FXML
    public RadioButton customerCurrentWeekRadioButton;

    /**
     * FXML radio button field variable to view current month of customers.
     */
    @FXML
    public RadioButton customerCurrentMonthRadioButton;

    /**
     * FXML radio button field variable to view all the customers.
     */
    @FXML
    public RadioButton customerAllAppointmentsRadioButton;

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

    private static Customer newCustomer = new Customer();

    private ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

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
            customerTableColumnStateAndProvince.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
            customerTableColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        } catch (Exception e) {
            e.printStackTrace(); }

    }


    /**
     * customerReportsButtonAction method to go to the reports page and view reports.
     *
     * @param actionEvent
     */
    public void customerReportsButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/ReportScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * customerAddButtonAction method to go to the add customer page and add a customer.
     *
     * @param actionEvent
     */
    public void customerAddButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/AddCustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * customerModifyButtonAction method to go to the modify customer page and modify the customer.
     *
     * @param actionEvent
     */
    public void customerModifyButtonAction(ActionEvent actionEvent) throws IOException {
        selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null)
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("ERROR");
            errorAlert.setContentText("NO CUSTOMER WAS SELECTED");
            errorAlert.showAndWait();
        }
        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/ModifyCustomerView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Modify Customer");
            stage.setScene(scene);
            stage.show();
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
     * @param actionEvent
     */
    public void customerDeleteButtonAction(ActionEvent actionEvent) throws Exception {
        selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null)
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("ERROR");
            errorAlert.setContentText("NO CUSTOMER WAS SELECTED");
            errorAlert.showAndWait();
        }
        else
        {
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
                customerTableColumnStateAndProvince.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
                customerTableColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

            }
            else
            {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("ERROR");
                errorAlert.setContentText("CUSTOMER WAS NOT DELETED");
                errorAlert.showAndWait();

            }
        }
    }

    /**
     * customerLogoutButtonAction method to logout of the application.
     *
     * @param actionEvent
     */
    public void customerLogoutButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * customerBackButtonAction method to go to the main menu of the application.
     *
     * @param actionEvent
     */
    public void customerBackButtonAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/MainScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Scheduling Desktop Application");
        stage.setScene(scene);
        stage.show();
    }
}