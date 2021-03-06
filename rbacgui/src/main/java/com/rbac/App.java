package com.rbac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static ArrayList<Role> allRoles = new ArrayList<>();
    static ArrayList<Operation> allOperations = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<User>();
    
    
    static User currentUser;
    static User selectedUser;
    static Role selectedRole;
    static Operation selectedOperation;
    
    static User admin;
    static boolean first = false;
    static final String filename = "rbacgui/src/main/java/com/local/data.json";

    @Override
    public void start(Stage stage) throws IOException {
        if(first) 
            scene = new Scene(loadFXML("registration"), 600, 400);
        else
            scene = new Scene(loadFXML("login"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    @Override
    public void stop() {
        save();
    }

    public static void save() {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File(filename), users);
        } catch (IOException e) {}
    }

    public static void read() {
        ObjectMapper om = new ObjectMapper();
        try {
            users = om.readValue(new File(filename), new TypeReference<ArrayList<User>>(){});
        } catch (IOException e) {
            
            users = new ArrayList<User>();
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        read();

        if(users.size() == 0) {
            first = true;
        }
        
        findAdmin();
        findAllRoles();
        findAllOperation();

        launch(args);
    }

    public static void findAdmin() {
        for(User u : users) {
            if(u.isAdmin()){
                admin = u;
                return;
            }
        }
    }

    public static void findAllRoles() {
        allRoles.clear();
        for(User u : users) {
            for(Role r : u.getRoles()) {
                if(!allRoles.contains(r)) {
                    allRoles.add(r);
                }
            }
        }
    }

    public static void findAllOperation() {
        allOperations.clear();
        for(Role r : allRoles) {
            for(Operation op : r.getOperations()) {
                if(!allOperations.contains(op)) {
                    allOperations.add(op);
                }
            }
        }
    }

}