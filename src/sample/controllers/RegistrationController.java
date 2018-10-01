package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DbHandler;
import sample.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController {

    @FXML
    private TextField firstName;

    @FXML
    private PasswordField regPassword;

    @FXML
    private Button registrationButtonGo;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private Button backToLogin;

    @FXML
    void initialize() {

        registrationButtonGo.setOnAction(event -> {
            registeringNewUser();
        });

        backToLogin.setOnAction(event -> {
            backToLogin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/views/login.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    }

    private void registeringNewUser() {
        DbHandler dbHandler = new DbHandler();

        String firstN = firstName.getText();
        String lastN = lastName.getText();
        String pass = regPassword.getText();
        String mail = email.getText();

        User user = new User(firstN, lastN, pass, mail);

        dbHandler.registrationUser(user);

    }
}

