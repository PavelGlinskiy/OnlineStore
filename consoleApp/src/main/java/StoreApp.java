import org.xml.sax.SAXException;
import store.utility.Menu;
import store.utility.RandomStorePopulator;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class StoreApp {

    public static void main(String[] args) {

        RandomStorePopulator.fillTheStoreRandomly("Korona");
        try {
            Menu.startMenu();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}