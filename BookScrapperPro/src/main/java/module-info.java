module org.example.bookscrapperpro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bookscrapperpro to javafx.fxml;
    exports org.example.bookscrapperpro;
}