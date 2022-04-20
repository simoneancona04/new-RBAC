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
    static User currentUser;
    static Role selectedRole;
    static Operation selectedOperation;
    static boolean first = false;
    static ArrayList<User> users = new ArrayList<User>();
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
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File(filename), users);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        try {
            users = om.readValue(new File(filename), new TypeReference<ArrayList<User>>(){});
        } catch (IOException e) {
            // TODO Auto-generated catch block
            users = new ArrayList<User>();
        }

        if(users.size() == 0) {
            first = true;
        }


        launch(args);
    }

}