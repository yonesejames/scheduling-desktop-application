package com.example.schedulingdesktopapplication.controller;

import com.example.schedulingdesktopapplication.DAO.CountryDAO;
import com.example.schedulingdesktopapplication.Main;
import com.example.schedulingdesktopapplication.model.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public TextField addCustomerIDTextField;

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
    public ComboBox<String> addCustomerStateOrProvinceComboBox;

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
     * Method to access database.
     *
     * @param sql
     * @return resultSet.
     */
    public ResultSet accessDB(String sql) {

        ResultSet resultSet = null;

        try {

            Statement statement;

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
//            resultSet.beforeFirst();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultSet;
    }

    /**
     * Method that initializes the countries for the country's ComboBox.
     */
    public void initializeCountry() {
//        ResultSet resultSet = accessDB("SELECT country FROM countries");
//        try {
//
//            while (resultSet.next()) {
//                addCustomerCountryComboBox.getItems().add(resultSet.getString(1));
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ComboBoxController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Method that initializes the cities for the city's ComboBox.
     */
    public void initializeStateOrProvince() {

//        String country = addCustomerCountryComboBox.getValue();
//
//        String sql = "SELECT division "
//                + "FROM first_level_divisions, countries "
//                + "WHERE first_level_divisions.Country_ID = countries.Country_ID "
//                + "AND country = \"" + country + "\"";
//
//        ResultSet resultSet = accessDB(sql);
//        addCustomerStateOrProvinceComboBox.getItems().clear();
//
//        try {
//            while (resultSet.next()) {
//
//                addCustomerStateOrProvinceComboBox.getItems().add(resultSet.getString(1));
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ComboBoxController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }


    /**
     * Initialize method for the AddCustomerController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initializeCountry();
        try {
            addCustomerCountryComboBox.setItems(CountryDAO.getAllCountries());
            addCustomerCountryComboBox.getSelectionModel().selectFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * addCustomerSaveAction method to save customer.
     *
     * @param actionEvent
     */
    public void addCustomerSaveAction(ActionEvent actionEvent) {
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
