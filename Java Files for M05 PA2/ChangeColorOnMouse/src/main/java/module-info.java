module com.example.changecoloronmouse {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.changecoloronmouse to javafx.fxml;
    exports com.example.changecoloronmouse;
}