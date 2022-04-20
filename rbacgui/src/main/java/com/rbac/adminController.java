package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class adminController {
    @FXML
    FlowPane usersBox;
    @FXML
    FlowPane rolesBox;
    @FXML
    FlowPane operationsBox;

    @FXML
    public void initialize(){
        Button tmp;

        for(User u:App.users){
            tmp = new Button(u.getUsername());
            //tmp.onActionProperty(e->{})
            tmp.setPrefWidth(240);
            usersBox.getChildren().add(tmp);
        }
        
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}