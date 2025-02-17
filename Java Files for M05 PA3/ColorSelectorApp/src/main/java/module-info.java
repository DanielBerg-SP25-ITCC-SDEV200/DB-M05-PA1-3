module com.example.colorselectorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.colorselectorapp to javafx.fxml;
    exports com.example.colorselectorapp;
}