package store.utility;

import domain.Category;
import domain.Product;
import domain.factory.BookCreator;
import domain.factory.CatCreator;
import domain.factory.Creator;
import domain.factory.DogCreator;
import domain.factory.FoodCreator;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import store.Store;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator {

    private static Map<Category, Integer> createProductMap(){
        Map<Category, Integer> productMap = new HashMap<>();
        Reflections reflections = new Reflections("domain.productCategories", new SubTypesScanner());
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type: subTypes) {
            try {
                Random random = new Random();
                productMap.put(type.getConstructor().newInstance(), random.nextInt(10)+1);
            } catch (InstantiationException
                    | InvocationTargetException
                    | NoSuchMethodException
                    | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return productMap;
    }

     public static Store fillTheStoreRandomly(String storeName){
        Map<Category, Integer> categoryProductMap = createProductMap();
        List<Product> productList = new ArrayList<>();
        Store store = Store.createStore(storeName);
        for (Map.Entry<Category,Integer> item: categoryProductMap.entrySet()) {
            for (int i = 0; i <item.getValue() ; i++) {
               try {
                   productList.add(Objects.requireNonNull(createCreator(
                            item.getKey()
                           .getNameCategory()))
                           .createProduct());
               }catch (NullPointerException e){
                   System.out.println("Невозможно создать продукт");
               }
            }
            store.getStoreMap().put(item.getKey(),productList);
        }
        return store;
    }

    private static Creator createCreator(String categoryName){
        switch (categoryName){
            case "Book":
                 return new BookCreator();
            case "Cat":
                 return new CatCreator();
            case "Dog":
                return new DogCreator();
            case "Food":
                return new FoodCreator();
            default:
                return null;
        }
    }
}
