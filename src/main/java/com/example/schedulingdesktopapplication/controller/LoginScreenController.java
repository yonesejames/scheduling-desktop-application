package com.example.schedulingdesktopapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

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
     *  FXML text field variable for the timezone.
     */
    @FXML
    public TextField loginTimeZone;

    /**
     * FXML choice box variable to choose a language.
     */
    @FXML
    public ChoiceBox loginLanguageChoiceBox;

    /**
     * Initialize method for the LoginScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * loginButtonAction method to log into the application.
     *
     * @param actionEvent
     */
    public void loginButtonAction(ActionEvent actionEvent) {
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
