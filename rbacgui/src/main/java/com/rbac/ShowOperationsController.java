package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ShowOperationsController {

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
        for(Operation o: App.allOperations){
            tmp = new Button(o.getName());
            tmp.setOnAction(e->{
                App.selectedOperation = o;
                try {
                    App.setRoot("operation");
                } catch (IOException e1) {}
                
            });
            container.getChildren().add(tmp);
        }



    }


    @FXML
    public void createButton() throws IOException {
        App.setRoot("operation");
    }


    @FXML
    public void cancelButton() throws IOException{
        App.setRoot("controlPanel");
    }
}
