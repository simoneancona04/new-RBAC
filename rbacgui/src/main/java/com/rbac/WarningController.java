package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class WarningController {

    private Stage st;
    
    @FXML
    Button okButton;

    @FXML
    Label message;

    @FXML
    public void initialize(String message) {
        this.message.setText(message);
    }

    public WarningController() {}

    public WarningController(String message) {
        st = new Stage();
        try {
            st.setScene(new Scene(App.loadFXML("warning")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        st.initStyle(StageStyle.UNDECORATED);
        this.message = new Label(message);

        st.showAndWait();
    }

    public void close() {
        st.close();
    }

}
