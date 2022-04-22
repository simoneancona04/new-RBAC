package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    private void switchWindow() throws IOException {
        String password = passwordField.getText();
        String username = usernameField.getText();
        
        if (username == "" || "" == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username o Password non possono essere vuoti");
            alert.showAndWait();
            return;
        };
        
        for(User u:App.users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                App.currentUser = u;
                App.setRoot("controlPanel");
                return;
            }
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Username o Password non validi");
        alert.showAndWait();
        //new WarningController("ciao");
    }
}
