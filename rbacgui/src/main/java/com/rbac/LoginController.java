package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    private void switchWindow() throws IOException {

        String password = passwordField.getText();
        String username = usernameField.getText();
        
        if (username == null || password == null) return;
        
        for(User u:App.users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                App.currentUser = u;
                App.setRoot("controlPanel");
                return;
            }
        }
        //new WarningController("ciao");
    }
}
