package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

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
    Button removeButton;

    @FXML
    HBox hBox;

    @FXML
    public void initialize() {
        if(App.selectedOperation != null) {
            titleLabel.setText("Modifica Operazione");
            nameField.setText(App.selectedOperation.getName());
            descriptionField.setText(App.selectedOperation.getDescription());
            createButton.setText("Salva");
        } else 
            hBox.getChildren().remove(removeButton);
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
            for(Operation o : App.allOperations) {
                if(o.getName().equals(name)) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Non ci possono essere due operazioni con lo stesso nome");
                    a.showAndWait();
                    return;
                }
            }
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

    @FXML
    public void remove() throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Sei sicuro di eliminare questa operazione?");
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK) {
            for(User u : App.users) {
                for(Role r : u.getRoles()) {
                    r.removeOperation(App.selectedOperation);
                }
            }
            App.save();
            App.read();
            App.findAllOperation();
            App.setRoot("showOperations");
        }
    }
}
