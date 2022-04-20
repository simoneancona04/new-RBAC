package com.rbac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static User currentUser;
    static ArrayList<User> users = new ArrayList<User>();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        users.add(new User("luca","123", true));

        Role Rtest = new Role("fornaio","prepara cibo");
        Rtest.addOperation(new Operation("fai la pizza","impasta etc"));

        User Utest = new User("marco","123");
        Utest.addRole(Rtest);
        users.add(Utest);
        launch();
    }

}