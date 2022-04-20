package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ControlPanelController {
    @FXML
    GridPane adminBox;

    @FXML
    FlowPane operationsBox;

    @FXML
    public void initialize(){
        if(!App.currentUser.isAdmin()){
            operationsBox.getChildren().clear();
        }
        
        
    }
}
