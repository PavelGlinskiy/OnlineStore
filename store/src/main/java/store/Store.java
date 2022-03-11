package store;

import domain.Category;
import domain.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private Map<Category, List<Product>> storeMap = new HashMap<>();
    private String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public void printStore(){
        System.out.println("\n" + this);
        for (Map.Entry<Category, List<Product>> entry : storeMap.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue().toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
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
        this.storeMap = storeMap;
    }
    
    @Override
    public String toString() {
        return "Store - " + storeName;
    }
}
