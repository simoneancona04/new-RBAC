package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ShowRolesController {

    @FXML
    Label titleLabel;


    @FXML
    FlowPane container;

    @FXML
    Button createButton;

    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        Button tmp;
        container.getChildren().clear();
        for(Role r: App.allRoles){
            tmp = new Button(r.getName());
            tmp.setOnAction(e->{
                App.selectedRole = r;
                try {
                    App.setRoot("role");
                } catch (IOException e1) {}
                
            });
            container.getChildren().add(tmp);
        }



    }


    @FXML
    public void createButton() throws IOException {
        App.setRoot("role");
    }


    @FXML
    public void cancelButton() throws IOException{
        App.setRoot("controlPanel");
    }
}
