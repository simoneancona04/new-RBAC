package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RoleController {

    @FXML
    Label titleLabel;

    @FXML
    TextField nameField;

    @FXML
    TextField descriptionField;

    @FXML
    FlowPane operationsBox;

    @FXML
    Button createButton;

    @FXML
    Button cancelButton;

    @FXML
    public void initialize() {
        if(App.selectedRole != null) {
            titleLabel.setText("Modifica Ruolo");
            nameField.setText(App.selectedRole.getName());
            descriptionField.setText(App.selectedRole.getDescription());
            createButton.setText("Salva");
        }
        operationsBox.getChildren().clear();
        for(Operation o: App.allOperations){
            Label lab = new Label(o.getName());
            lab.setGraphic(new CheckBox()); //TODO aggiungere un riferimento per capire se è spuntato
            lab.setContentDisplay(ContentDisplay.LEFT);
            operationsBox.getChildren().add(lab);
        }



    }


    @FXML
    public void createRole() throws IOException {

        String name = nameField.getText();
        String description = descriptionField.getText();
        
        if (name == "" || description == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome o Descrizione non validi");
            alert.showAndWait();
            return;
        }

        
        if(App.selectedRole != null) {
            App.selectedRole.setName(name);
            App.selectedRole.setDescription(description);
        }
        else{
            // TODO inserire in un array di operations
            App.allRoles.add(new Role(name,description));
        }



        App.setRoot("controlPanel"); //TODO  andare a view operations?
        
    }
}
