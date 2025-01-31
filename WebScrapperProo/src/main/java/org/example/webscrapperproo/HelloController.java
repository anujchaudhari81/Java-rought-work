package org.example.webscrapperproo;

import javafx.scene.control.TextArea;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField tf1;

    @FXML
    private TextArea outputId;
    private String url;

    @FXML
    protected void onHelloButtonClick() {
        url = tf1.getText();

        // Validate URL
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            outputId.setText(" Invalid URL! ");
            return;
        }

        // Background Task for Web Scraping
        Task<Void> scrapeTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Document document = Jsoup.connect(url).get();
                    Elements books = document.select(".product_pod");

                    StringBuilder results = new StringBuilder();

                    for (Element book : books) {
                        String title = book.select("h3 > a").text();
                        String price = book.select(".price_color").text();
                        results.append(title).append(" - ").append(price).append("\n");
                    }

                    // Update the UI on the JavaFX Application Thread
                    javafx.application.Platform.runLater(() -> {
                        outputId.setText(results.toString());
                    });
                } catch (IOException e) {
                    outputId.setText("Error: Unable to fetch data.");
                    e.printStackTrace();
                }
                return null;
            }
        };

        // Bind task message to label
        welcomeText.textProperty().bind(scrapeTask.messageProperty());

        // Run task in a background thread
        new Thread(scrapeTask).start();
    }
}
