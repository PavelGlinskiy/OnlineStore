package store.utility;

import domain.Category;
import domain.Product;
import store.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuyProducts {
    private static List<Product> products = new ArrayList<>();

    public static synchronized void purchase(String productName){
        boolean mark = false;
        System.out.println(Thread.currentThread().getName());
        for (Map.Entry<Category, List<Product>> entry: Store.storeMap.entrySet()) {
            for (Product product:entry.getValue()) {
                if (productName.equals(product.getNameProduct())){
                    products.add(product);
                    mark = true;
                }
            }
        }
        if (mark){
            System.out.println("Желаемый продукт добавлен");
        }else System.out.println("Продукт не найден");
        Menu.menuPrint();
    }

    public static void printPurchases(){
        for (Product entry: products) {
            System.out.print(entry.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static synchronized void clearProducts(){
        products.clear();
    }
}
