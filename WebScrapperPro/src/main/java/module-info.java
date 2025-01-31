module org.example.webscrapperpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.compiler;


    opens org.example.webscrapperpro to javafx.fxml;
    exports org.example.webscrapperpro;
}