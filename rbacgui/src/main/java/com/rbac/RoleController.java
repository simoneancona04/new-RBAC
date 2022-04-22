package com.rbac;

import java.io.IOException;
import java.util.ArrayList;

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
    FlowPane operationBox;

    @FXML
    Button saveButton;

    @FXML
    Button cancelButton;

    ArrayList<CheckBox> checkboxes;

    @FXML
    public void initialize() {
        if(App.selectedRole != null) {
            titleLabel.setText("Modifica " + App.selectedRole.getName() );
            nameField.setText(App.selectedRole.getName());
            descriptionField.setText(App.selectedRole.getDescription());
            saveButton.setText("Salva");
        }
        operationBox.getChildren().clear();
        CheckBox tmp;
        checkboxes = new ArrayList<>();

        for(Operation o: App.allOperations){
            Label lab = new Label(o.getName());
            tmp = new CheckBox();
            if(App.selectedRole!=null) tmp.setSelected(App.selectedRole.getOperations().contains(o));
            checkboxes.add(tmp);  
            lab.setGraphic(tmp);
            lab.setContentDisplay(ContentDisplay.LEFT);
            operationBox.getChildren().add(lab);
        }

    }


    @FXML
    public void save() throws IOException {

        String name = nameField.getText();
        String description = descriptionField.getText();
        
        if (name == "" || description == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome o Descrizione non validi");
            alert.showAndWait();
            return;
        }
        Role tmp = new Role();


        App.admin.addRole(tmp);
        App.allRoles.add(tmp);
        App.selectedRole = tmp;
        App.selectedRole.setName(name);
        App.selectedRole.setDescription(description);
        App.selectedRole.setOperations(new ArrayList<Operation>());

        for(int i = 0; i < checkboxes.size(); i++){
            if(checkboxes.get(i).isSelected()) App.selectedRole.addOperation(App.allOperations.get(i));
            else App.selectedRole.removeOperation(App.allOperations.get(i));
        }
       

        App.selectedRole = null;
        App.setRoot("showRoles");
    }

    
    @FXML
    public void cancelButton() throws IOException{
        App.selectedRole = null;
        App.setRoot("showRoles");
    }
}
