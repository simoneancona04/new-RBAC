package com.rbac;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {
    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    CheckBox adminCheckBox;

    @FXML
    Button createButton;

    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        if(App.first) {
            adminCheckBox.setSelected(true);
        }
    }

    public void check() {
        if(App.first) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Il primo utente creato deve essere amministratore");

            alert.showAndWait();
            adminCheckBox.setSelected(true);
        }
    }

    @FXML
    public void createUser() throws IOException {

        String password = passwordField.getText();
        String username = usernameField.getText();
        
        if (username == "" || password == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username o Password non validi");
            alert.showAndWait();
            return;
        }

        
        App.users.add(new User(usernameField.getText(), passwordField.getText(), new ArrayList<Role>(), adminCheckBox.isSelected()));
        
        if(App.first) {
            App.currentUser = App.users.get(0);
            App.setRoot("login");
        }
        else{
            App.setRoot("controlPanel");
        }
    }
}
