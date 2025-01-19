import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class BookScrapper {
    public static void main(String[] args) {
        String url = "https://books.toscrape.com";

        try {
            // Fetch and parse the HTML from the URL
            Document document = Jsoup.connect(url).get();
            // Select all elements with the class 'product_pod'
            Elements books = document.select(".product_pod");

            System.out.println("================");
            System.out.println("Web Scraper Pro");
            // Iterate over each book element
            for (Element book : books) {
                // Extract the title and price
                String title = book.select("h3 > a").text();
                String price = book.select(".price_color").text();
                System.out.println(title + " - " + price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
