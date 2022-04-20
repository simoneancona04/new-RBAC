package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ControlPanelController {
    @FXML
    GridPane adminBox;

    @FXML
    FlowPane operationsBox;

    @FXML
    Label nameLabel;
    
    @FXML
    public void initialize(){
        nameLabel.setText(App.currentUser.getUsername());



        if(!App.currentUser.isAdmin()){
            adminBox.getChildren().clear();
            operationsBox.getChildren().clear();

            Button tmp;
            for(Operation o:App.currentUser.getOperations()){
                tmp = new Button(o.getName());
                FlowPane.setMargin(tmp,new Insets(5, 5, 5, 5));
                operationsBox.getChildren().add(tmp);
            }
        }
        
        
    }

    @FXML
    public void showUsers(){

    }

    @FXML
    public void showRoles(){
        
    }

    @FXML
    public void showOperations(){
        
    }



    @FXML
    public void cancel() throws IOException{
        App.setRoot("login");
    }
}
