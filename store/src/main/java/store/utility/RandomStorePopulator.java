package store.utility;

import com.github.javafaker.Faker;
import domain.Category;
import domain.Product;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import store.Store;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator {
    private Faker faker = new Faker();

    public String getNameProduct(String nameCategory){
        switch (nameCategory){
            case "Book":
                return faker.book().title();
            case "Cat":
                return faker.cat().breed();
            case "Dog":
                return faker.dog().breed();
            case "Food":
                return faker.food().dish();
            default:
                return null;
        }
    }

    public Double getPrice(){return faker.number().randomDouble(1,1,100);}

    public Double getRate(){return faker.number().randomDouble(1,1,20);}

    private static Map<Category, Integer> createProductMap(){
        Map<Category, Integer> productMap = new HashMap<>();

        Reflections reflections = new Reflections("domain.productCategories", new SubTypesScanner());
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type: subTypes) {
            try {
                Random random = new Random();
                productMap.put(type.getConstructor().newInstance(), random.nextInt(10)+1);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return productMap;
    }

     public static Store fillTheStoreRandomly(String storeName){
        RandomStorePopulator populator = new RandomStorePopulator();
        Map<Category, Integer> categoryProductMap = createProductMap();
        List<Product> productList = new ArrayList<>();
        Store store = new Store(storeName);

        for (Map.Entry<Category,Integer> item: categoryProductMap.entrySet()) {
            for (int i = 0; i <item.getValue() ; i++) {
                Product product = new Product(
                        populator.getNameProduct(item.getKey().getNameCategory()),
                        populator.getPrice(),
                        populator.getRate());
                productList.add(product);
            }
            store.getStoreMap().put(item.getKey(),productList);
        }
        return store;
    }
}
