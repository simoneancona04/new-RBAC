package com.rbac;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class EditUserController {

    @FXML
    Label titleLabel;

    @FXML
    TextField nameField;

    @FXML
    PasswordField passwordField;

    @FXML
    FlowPane roleBox;

    @FXML
    Button saveButton;

    @FXML
    Button cancelButton;

    ArrayList<CheckBox> checkboxes;

    @FXML
    public void initialize() {
        if(App.selectedUser != null) {
            titleLabel.setText("Modifica " + App.selectedUser.getUsername() );
            nameField.setText(App.selectedUser.getUsername());
            passwordField.setText(App.selectedUser.getPassword());
            saveButton.setText("Salva");
        }
        roleBox.getChildren().clear();
        CheckBox tmp;
        checkboxes = new ArrayList<>();

        for(Role r: App.allRoles){
            Label lab = new Label(r.getName());
            tmp = new CheckBox();
            if(App.selectedUser!=null)tmp.setSelected(App.selectedUser.getRoles().contains(r));
            checkboxes.add(tmp);  
            lab.setGraphic(tmp);
            lab.setContentDisplay(ContentDisplay.LEFT);
            roleBox.getChildren().add(lab);
        }

    }

    @FXML
    public void remove() throws IOException{
        if(App.currentUser.isAdmin()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Impossibile rimuovere l'amministratore");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Sei sicuro di eliminare questo utente?");
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK) {
            App.users.remove(App.selectedUser);
            App.setRoot("showUsers");
        }
    }


    @FXML
    public void save() throws IOException {

        String name = nameField.getText();
        String password = passwordField.getText();
        
        if (name == "" || password == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome o Password non validi");
            alert.showAndWait();
            return;
        }


        App.selectedUser.setUsername(name);
        App.selectedUser.setPassword(password);

        for(int i = 0; i < checkboxes.size(); i++){
            if(checkboxes.get(i).isSelected()) App.selectedUser.addRole(App.allRoles.get(i));
            else App.selectedUser.removeRole(App.allRoles.get(i));
        }
       

        App.selectedUser = null;
        App.setRoot("showUsers");
    }

    
    @FXML
    public void cancelButton() throws IOException{
        App.selectedUser = null;
        App.setRoot("showUsers");
    }
}
