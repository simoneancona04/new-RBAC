package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ShowUsersController {

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
        for(User u: App.users){
            tmp = new Button(u.getUsername());
            tmp.setOnAction(e->{
                App.selectedUser = u;
                try {
                    App.setRoot("editUser");
                } catch (IOException e1) {}
                
            });
            container.getChildren().add(tmp);
        }



    }


    @FXML
    public void createButton() throws IOException {
        App.setRoot("editUser");
        App.setRoot("registration");
    }


    @FXML
    public void cancelButton() throws IOException{
        App.setRoot("controlPanel");
    }
}
