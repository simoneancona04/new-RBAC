package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;

public class UserController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
