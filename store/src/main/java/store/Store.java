package store;

import domain.Category;
import domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Store {
    private static Map<Category, List<Product>> storeMap = new HashMap<>();
    private String storeName;
    private static volatile Store store;

    private Store(String storeName) {
        this.storeName = storeName;
    }

    public static void printStore(){
        for (Map.Entry<Category, List<Product>> entry : storeMap.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue().toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static void sortedStore(Map<String,String> map, String key) {
        for (Map.Entry<Category, List<Product>> entry : storeMap.entrySet()) {
            switch (key) {
                case "name":
                    switch (map.get(key)){
                        case "ASC":
                            entry.getValue().sort((o1, o2) -> o1.getNameProduct().compareTo(o2.getNameProduct()));
                            break;
                        case "DESC":
                            entry.getValue().sort((o1, o2) -> o2.getNameProduct().compareTo(o1.getNameProduct()));
                            break;
                    }
                    break;
                case "price":
                    switch (map.get(key)){
                        case "ASC":
                            entry.getValue().sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
                            break;
                        case "DESC":
                            entry.getValue().sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
                            break;
                    }
                    break;
                case "rate":
                    switch (map.get(key)){
                        case "ASC":
                            entry.getValue().sort((o1, o2) -> Double.compare(o1.getRate(), o2.getRate()));
                            break;
                        case "DESC":
                            entry.getValue().sort((o1, o2) -> Double.compare(o2.getRate(), o1.getRate()));
                            break;
                    }
            }
            System.out.print(entry.getKey() + " " + entry.getValue().toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static void topProducts(){
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Category, List<Product>> entry : storeMap.entrySet()){
            List<Product> list = entry.getValue();
            products.addAll(list);
            List<Product> sortedProducts = list.stream()
                    .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                    .skip(products.size()-5)
                    .collect(Collectors.toList());
            System.out.println(sortedProducts.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static Store createStore(String storeName){
        Store result = store;
        if (result != null){
            return result;
        }
        synchronized (Store.class){
            if (store == null){
                store = new Store(storeName);
            }
            return store;
        }
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Map<Category, List<Product>> getStoreMap() {
        return storeMap;
    }

    public void setStoreMap(Map<Category, List<Product>> storeMap) {
        Store.storeMap = storeMap;
    }
    
    @Override
    public String toString() {
        return "Store - " + storeName;
    }
}
