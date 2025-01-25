package org.example.webscrapperpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Set up a BorderPane as the root and add the FXML content to it
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: #3e4a52;");
        pane.setCenter(fxmlLoader.load());

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(pane, 820, 640);

        // Set the stage properties
        stage.setTitle("Web Scrapper+");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}