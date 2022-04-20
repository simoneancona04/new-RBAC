package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;

public class adminController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}