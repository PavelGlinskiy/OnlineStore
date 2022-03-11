import store.Store;
import store.utility.RandomStorePopulator;
import java.util.Arrays;
import java.util.List;

public class StoreApp {

    public static void main(String[] args) {
        List<Store> stores = Arrays.asList(RandomStorePopulator.fillTheStoreRandomly("ES"),
                RandomStorePopulator.fillTheStoreRandomly("Korona"),
                RandomStorePopulator.fillTheStoreRandomly("Groshik"));
        printAllStores(stores);
    }

    public static void printAllStores(List<Store> stores){
        for (Store store:stores) {
            store.printStore();
        }
    }
}
