module org.example.webscrapperpro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.webscrapperpro to javafx.fxml;
    exports org.example.webscrapperpro;
}