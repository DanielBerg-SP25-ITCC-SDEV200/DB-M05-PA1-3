package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.InputStream;

public class DisplayImages extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5); // Set horizontal gap between columns
        gridPane.setVgap(5); // Set vertical gap between rows
        gridPane.setPadding(new Insets(10)); // Set padding around the grid

        // Load the images (replace with your actual image paths)
        Image gif1 = new Image(getClass().getResourceAsStream("/flag1.gif")); // Or new Image("file:path/to/image1.png"); for file paths
        Image gif2 = new Image(getClass().getResourceAsStream("/flag2.gif"));
        Image gif6 = new Image(getClass().getResourceAsStream("/flag6.gif"));
        Image gif7 = new Image(getClass().getResourceAsStream("/flag7.gif"));


        // Create ImageViews and add them to the GridPane
        ImageView imageView1 = new ImageView(gif1);
        ImageView imageView2 = new ImageView(gif2);
        ImageView imageView6 = new ImageView(gif6);
        ImageView imageView7 = new ImageView(gif7);

        //You can set preferred sizes if needed
        imageView1.setFitWidth(410);
        imageView1.setFitHeight(410);
        imageView1.setPreserveRatio(true);
        imageView2.setFitWidth(450);
        imageView2.setFitHeight(450);
        imageView2.setPreserveRatio(true);
        imageView6.setFitWidth(410);
        imageView6.setFitHeight(410);
        imageView6.setPreserveRatio(true);
        imageView7.setFitWidth(450);
        imageView7.setFitHeight(450);
        imageView7.setPreserveRatio(true);



        gridPane.add(imageView1, 0, 0); // Column 0, Row 0
        gridPane.add(imageView2, 1, 0); // Column 1, Row 0
        gridPane.add(imageView6, 0, 1); // Column 0, Row 1
        gridPane.add(imageView7, 1, 1); // Column 1, Row 1

        // Create a Scene and set it to the Stage
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Images");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}