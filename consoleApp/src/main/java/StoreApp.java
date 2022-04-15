import org.xml.sax.SAXException;
import store.utility.Menu;
import store.utility.RandomStorePopulator;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;


public class StoreApp {

    public static void main(String[] args) {


        try {
            RandomStorePopulator.fillTheStoreRandomly("Korona");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Menu.startMenu();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}