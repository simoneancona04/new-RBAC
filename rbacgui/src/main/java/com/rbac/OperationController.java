package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OperationController {

    @FXML
    Label titleLabel;

    @FXML
    TextField nameField;

    @FXML
    TextField descriptionField;

    @FXML
    Button createButton;

    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        if(App.selectedOperation != null) {
            titleLabel.setText("Modifica Operazione");
            nameField.setText(App.selectedOperation.getName());
            descriptionField.setText(App.selectedOperation.getDescription());
            createButton.setText("Salva");
        }
    }


    @FXML
    public void createOperation() throws IOException {

        String name = nameField.getText();
        String description = descriptionField.getText();
        
        if (name == "" || description == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome o Descrizione non validi");
            alert.showAndWait();
            return;
        }

        
        if(App.selectedOperation != null) {
            App.selectedOperation.setName(name);
            App.selectedOperation.setDescription(description);
        }
        else{
            App.allOperations.add(new Operation(name, description));
        }

        App.selectedOperation = null;

        App.setRoot("showOperations"); 
        
    }
    @FXML
    public void cancelButton() throws IOException{
        App.selectedOperation = null;
        App.setRoot("showOperations");
    }
}
