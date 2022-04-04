import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import store.Store;
import store.utility.RandomStorePopulator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {
        RandomStorePopulator.fillTheStoreRandomly("Korona");
        try {
            startMenu();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void menuPrint(){
        System.out.println("\n" + "### МЕНЮ ###");
        System.out.println("1. Print Store");
        System.out.println("2. Sorting");
        System.out.println("3. Top");
        System.out.println("4. Exit");
    }

    public static void startMenu() throws ParserConfigurationException, IOException, SAXException {
        Scanner userInput = new Scanner(System.in);
        menuPrint();
        while (userInput.hasNext()){
            chooseMenu(userInput.nextInt());
            menuPrint();
        }
    }

    public static void chooseMenu(int numMenu) throws ParserConfigurationException, SAXException, IOException {
        switch (numMenu) {
            case 1 :
                Store.printStore();
                break;
            case 2 :
                startMenuSort();
                break;
            case 3 : Store.topProducts();
                break;
            case 4: System.exit(0);
            default:
                System.out.println("Не правильно выбран пункт");
        }
    }

    public static void menuSort(){
        System.out.println("\n" + "### SORTING ###");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Rate");
        System.out.println("4. Back");
        System.out.println("5. Exit");
    }

    public static void startMenuSort() throws IOException, SAXException, ParserConfigurationException {
        Scanner userInput = new Scanner(System.in);
        menuSort();
        while (userInput.hasNext()){
            chooseMenuSort(userInput.nextInt());
            menuSort();
        }
    }

    public static void chooseMenuSort(int number)throws ParserConfigurationException, IOException, SAXException{
        Map<String, String> mapSort = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("domain/src/main/resources/sort.xml"));
        Node nList = document.getElementsByTagName("sort").item(0);
        NodeList nodeList = nList.getChildNodes();
        Element element;
        for (int i = 0; i <nodeList.getLength() ; i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nodeList.item(i);
                mapSort.put(element.getTagName().toLowerCase(Locale.ROOT), element.getTextContent().toUpperCase(Locale.ROOT));
            }
        }
        switch (number){
            case 1:
                Store.sortedStore(mapSort,"name");
                break;
            case 2:
                Store.sortedStore(mapSort,"price");
                break;
            case 3:
                Store.sortedStore(mapSort,"rate");
                break;
            case 4: startMenu();
                break;
            case 5: System.exit(0);
            default:
                System.out.println("Не правильно выбран пункт");
        }
    }
}