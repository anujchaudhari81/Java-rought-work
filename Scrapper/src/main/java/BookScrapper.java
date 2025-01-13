import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.io.IOException;


public class BookScrapper {
    public static void main(String[] args){
        String url="https://books.toscrape.com";

        try{
            Document document = (Document) Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");

            for(Elements bk : books){

            }
        }catch(IOException  e){
            e.printStackTrace();
        }

    }
}
