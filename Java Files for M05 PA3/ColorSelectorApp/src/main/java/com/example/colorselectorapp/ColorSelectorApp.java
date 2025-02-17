package com.example.colorselectorapp;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ColorSelectorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label to display text with color
        Label label = new Label("Show Colors");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Create sliders for red, green, blue, and opacity with labels
        HBox redBox = createColorSlider("Red");
        HBox greenBox = createColorSlider("Green");
        HBox blueBox = createColorSlider("Blue");
        HBox opacityBox = createColorSlider("Opacity");

        // Set initial values for the sliders
        ((Slider) redBox.getChildren().get(1)).setValue(0);
        ((Slider) greenBox.getChildren().get(1)).setValue(0);
        ((Slider) blueBox.getChildren().get(1)).setValue(0);
        ((Slider) opacityBox.getChildren().get(1)).setValue(255);

        // Update label color based on slider values
        ((Slider) redBox.getChildren().get(1)).valueProperty().addListener(createColorChangeListener(label, redBox, greenBox, blueBox, opacityBox));
        ((Slider) greenBox.getChildren().get(1)).valueProperty().addListener(createColorChangeListener(label, redBox, greenBox, blueBox, opacityBox));
        ((Slider) blueBox.getChildren().get(1)).valueProperty().addListener(createColorChangeListener(label, redBox, greenBox, blueBox, opacityBox));
        ((Slider) opacityBox.getChildren().get(1)).valueProperty().addListener(createColorChangeListener(label, redBox, greenBox, blueBox, opacityBox));

        // Create the layout and add components
        VBox vbox = new VBox(10, label, redBox, greenBox, blueBox, opacityBox);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Set the scene and stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Color Picker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create a slider with a label positioned on the left side
    private HBox createColorSlider(String labelText) {
        Label sliderLabel = new Label(labelText);
        sliderLabel.setStyle("-fx-font-size: 14px;");

        Slider slider = new Slider(0, 255, 0);
        slider.setBlockIncrement(1);
        slider.setOrientation(javafx.geometry.Orientation.HORIZONTAL);
        slider.setMaxHeight(30);  // Make the slider more square (height adjustment)
        slider.setMinHeight(30);  // Make the slider more square (height adjustment)
        slider.setShowTickLabels(false);  // Remove tick labels
        slider.setShowTickMarks(false);   // Remove tick marks

        // Add the label on the left side of the slider
        HBox sliderBox = new HBox(10, sliderLabel, slider);
        sliderBox.setStyle("-fx-alignment: center;");

        return sliderBox;
    }

    // Create listener to update label color based on slider values
    private ChangeListener<Number> createColorChangeListener(Label label, HBox redBox, HBox greenBox, HBox blueBox, HBox opacityBox) {
        return (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            int red = (int) ((Slider) redBox.getChildren().get(1)).getValue();
            int green = (int) ((Slider) greenBox.getChildren().get(1)).getValue();
            int blue = (int) ((Slider) blueBox.getChildren().get(1)).getValue();
            int opacity = (int) ((Slider) opacityBox.getChildren().get(1)).getValue();

            // Format the color in RGB with opacity as hex
            String color = String.format("#%02X%02X%02X%02X", red, green, blue, opacity);
            label.setStyle("-fx-text-fill: " + color);
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}



