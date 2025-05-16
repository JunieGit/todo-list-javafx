/**
 * Main application class for the JavaFX To-Do List App.
 * This class launches the user interface by loading the FXML layout
 * and displaying the primary window (Stage).

 * It extends the JavaFX Application class and serves as the entry point
 * for the program.
 *
 * @author Min Htet Khant
 * @date May 2025
 */

package com.example.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodolistApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}