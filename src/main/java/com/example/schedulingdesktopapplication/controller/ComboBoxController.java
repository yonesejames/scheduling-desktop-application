package com.example.schedulingdesktopapplication.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.example.schedulingdesktopapplication.DAO.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboBoxController implements Initializable {

    @FXML
    private ComboBox<String> cboCountry;

    @FXML
    private ComboBox<String> cboCity;

    private Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initializeCountry() {
        ResultSet resultSet = accessDB("SELECT country FROM countries");
        try {

            while (resultSet.next()) {

                cboCountry.getItems().add(resultSet.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void selectUS(ActionEvent event) {

        cboCountry.getSelectionModel().select("US");
    }

    @FXML
    void selectUK(ActionEvent event) {

        cboCountry.getSelectionModel().select("UK");
    }

    @FXML
    void selectCanada(ActionEvent event) {

        cboCountry.getSelectionModel().select("Canada");
    }

    @FXML
    private void initializeCity(int countryID) {

        String sql = "SELECT division"
                + "FROM first_level_divisions, countries"
                + "WHERE first_level_divisions.Country_ID = " + countryID;

        ResultSet resultSet = accessDB(sql);
        cboCity.getItems().clear();

        try {
            while (resultSet.next()) {

                cboCity.getItems().add(resultSet.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet accessDB(String sql) {

        ResultSet resultSet = null;

        try {

            Statement stmt;

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            resultSet.beforeFirst();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultSet;
    }
}