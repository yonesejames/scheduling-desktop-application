package com.example.schedulingdesktopapplication.controller;
import com.example.schedulingdesktopapplication.Main;
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
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import static com.example.schedulingdesktopapplication.DAO.UserDAO.validateUser;
import java.time.ZoneId;

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
     * Username to log into the Scheduling Desktop Application.
     */
    static public String username;

    /**
     * Password to log into the Scheduling Desktop Application.
     */
    static public String password;


    /**
     * Initialize method for the LoginScreenController to initialize the stage and items.
     *
     * @param url for the url path.
     * @param resourceBundle for the resource.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginTimeZoneLabel2.setText(String.valueOf(ZoneId.systemDefault()));

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
     * loginButtonAction method to log into the application.
     *
     * @param actionEvent
     */
    public void loginButtonAction(ActionEvent actionEvent) throws Exception {
        username = loginUsernameTextField.getText();
        password = loginPasswordTextField.getText();

        try
        {
            if(validateUser(username, password))
            {
                showScreen(actionEvent, "view/MainScreenView.fxml", "Main");
            }
            else
            {
                alertMessage("Error", "USER DOES NOT EXIST");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * loginExitButtonAction method to exit the application.
     *
     * @param actionEvent
     */
    public void loginExitButtonAction(ActionEvent actionEvent) { System.exit(0); }

    /**
     * loginUsernameAction method for the username field.
     *
     * @param actionEvent
     */
    public void loginUsernameAction(ActionEvent actionEvent) {
    }

    /**
     * loginPasswordAction method for the password field.
     *
     * @param actionEvent
     */
    public void loginPasswordAction(ActionEvent actionEvent) {
    }


}
