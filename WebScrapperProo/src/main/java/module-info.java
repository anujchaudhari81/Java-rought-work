module org.example.webscrapperproo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens org.example.webscrapperproo to javafx.fxml;
    exports org.example.webscrapperproo;
}