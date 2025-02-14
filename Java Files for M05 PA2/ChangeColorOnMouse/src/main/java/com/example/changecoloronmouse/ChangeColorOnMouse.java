package com.example.changecoloronmouse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ChangeColorOnMouse extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circle
        Pane pane = new Pane();

        // Create a Circle with initial color black
        Circle circle = new Circle(100, 100, 50); // Position at (100, 100), radius 50
        circle.setFill(Color.BLACK); // Set initial color to black for visibility
        pane.getChildren().add(circle); // Add circle to the pane

        // Event handler for mouse pressed
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK); // Change color to black when pressed
        });

        // Event handler for mouse released
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE); // Change color to white when released
        });

        // Create a Scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400); // Set scene size (400x400)
        primaryStage.setTitle("Change Color on Mouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

