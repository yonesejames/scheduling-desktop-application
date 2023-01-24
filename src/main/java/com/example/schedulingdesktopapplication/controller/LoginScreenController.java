package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.example.schedulingdesktopapplication.DAO.JDBC;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Controller class that views the login page in the application.
 *
 * @author Yonese James
 */
public class LoginScreenController implements Initializable {
    /**
     *  FXML text field variable for the username.
     */
    @FXML
    public TextField loginUsernameTextField;
    /**
     *  FXML password field variable for the password.
     */
    @FXML
    public PasswordField loginPasswordTextField;

    /**
     *  FXML exit button variable to exit the application.
     */
    @FXML
    public Button loginExitButton;

    /**
     * FXML choice box variable to choose a language.
     */
    @FXML
    public ChoiceBox loginLanguageChoiceBox;

    /**
     * FXML label variable for title.
     */
    @FXML
    public Label loginTitleLabel;

    /**
     * FXML label variable for username.
     */
    @FXML
    public Label loginUsernameLabel;

    /**
     * FXML label variable for password.
     */
    @FXML
    public Label loginPasswordLabel;

    /**
     * FXML button to log into application.
     */
    @FXML
    public Button loginButton;

    /**
     * FXML label variable for timezone.
     */
    @FXML
    public Label loginTimeZoneLabel1;

    /**
     * FXML label variable for timezone.
     */
    @FXML
    public Label loginTimeZoneLabel2;

    /**
     * FXML label variable for language.
     */
    @FXML
    public Label loginLanguageLabel;


    /**
     * Initialize method for the LoginScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale france = new Locale("fr", "FR");
        Locale english = new Locale("en", "EN");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a language (en or fr) : ");
        String languageCode = keyboard.nextLine();

        if(languageCode.equals("fr"))
        {
            Locale.setDefault(france);
        }
        else if(languageCode.equals("en"))
        {
            Locale.setDefault(english);
        }
        else
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("ERROR");
            errorAlert.setContentText("LANGUAGE NOT SUPPORTED");
            errorAlert.showAndWait();
            System.exit(0);
        }

        ResourceBundle rb = ResourceBundle.getBundle("Natural", Locale.getDefault());
        loginTitleLabel.setText(rb.getString("title"));
        loginUsernameLabel.setText(rb.getString("username"));
        loginPasswordLabel.setText(rb.getString("password"));
        loginButton.setText(rb.getString("login"));
        loginExitButton.setText(rb.getString("exit"));
        loginTimeZoneLabel1.setText(rb.getString("timezone"));
        loginTimeZoneLabel2.setText((rb.getString("timezonelabel")));
        loginLanguageLabel.setText(rb.getString("language"));
    }

    /**
     * loginButtonAction method to log into the application.
     *
     * @param actionEvent
     */
    public void loginButtonAction(ActionEvent actionEvent) throws IOException {
        String username = loginUsernameTextField.getText();
        String password = loginPasswordTextField.getText();

        //  Search through database to ensure the username and password exist in users table:
        // CODE HERE
    }

    /**
     * loginExitButtonAction method to exit the application.
     *
     * @param actionEvent
     */
    public void loginExitButtonAction(ActionEvent actionEvent) {
    }

    /**
     * loginUsernameTextFieldAction method for the username field.
     *
     * @param actionEvent
     */
    public void loginUsernameTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * loginPasswordTextFieldAction method for the password field.
     *
     * @param actionEvent
     */
    public void loginPasswordTextFieldAction(ActionEvent actionEvent) {
    }

    /**
     * loginTimeZoneAction method for the timezone.
     *
     * @param actionEvent
     */
    public void loginTimeZoneAction(ActionEvent actionEvent) {
    }
}
