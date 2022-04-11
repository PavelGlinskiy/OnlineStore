package store.utility;

import domain.Category;
import domain.Product;
import store.Store;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyProducts {
    private volatile static Map<Category, List<Product>> purchasedProducts = new HashMap<>();
    private static List<Product> products = new ArrayList<>();
    public static synchronized void purchase(String productName){
        boolean mark = false;
        System.out.println(Thread.currentThread().getName());
        for (Map.Entry<Category, List<Product>> entry: Store.storeMap.entrySet()) {
            for (Product product:entry.getValue()) {
                if (productName.equals(product.getNameProduct())){
                    products.add(product);
                    purchasedProducts.put(entry.getKey(), products);
                    mark = true;
                }
            }
            break;
        }
        if (mark){
            System.out.println("Желаемый продукт добавлен");
        }else System.out.println("Продукт не найден");
        Menu.menuPrint();
    }

    public static void printPurchases(){
        System.out.println(Thread.currentThread().getName());
        for (Map.Entry<Category, List<Product>> entry : purchasedProducts.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue().toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static synchronized void clearProducts(){
        products.clear();
        purchasedProducts.clear();
    }
}
