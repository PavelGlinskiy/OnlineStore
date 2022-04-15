package store.utility;

import domain.Category;
import domain.Product;
import domain.factoryCategories.CategoryBookCreator;
import domain.factoryCategories.CategoryCatCreator;
import domain.factoryCategories.CategoryCreator;
import domain.factoryCategories.CategoryDogCreator;
import domain.factoryCategories.CategoryFoodCreator;
import domain.factoryProducts.BookCreator;
import domain.factoryProducts.CatCreator;
import domain.factoryProducts.ProductCreator;
import domain.factoryProducts.DogCreator;
import domain.factoryProducts.FoodCreator;
import store.Store;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomStorePopulator {

    public static final String jdbcURL = "jdbc:h2:D:/Programming/IsSoft/OnlineStore/store/db/productsList";
    public static final String userName = "sa";
    public static final String password = "";
    private static Connection connection;

     public static Store fillTheStoreRandomly(String storeName) throws SQLException {
         Store store = Store.createStore(storeName);
         List<Category> categoryList = getDBCategories();
         List<Product> productList = getDBProduct();
         for (Category item:categoryList) {
             List<Product> sortedProduct = new ArrayList<>();
             for (Product product : productList) {
                 if (item.getId() == product.getIdCategory()) {
                     sortedProduct.add(product);
                 }
             }
             store.getStoreMap().put(item, sortedProduct);
         }
         return store;
    }

    private static void connectoinDB(){
        try {
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("БД подключена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Product> getDBProduct() throws SQLException {
        List<Product> productList = new ArrayList<>();
        connectoinDB();
        String sql = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nameProduct = resultSet.getString("name_product");
            double price = resultSet.getDouble("price");
            double rate = resultSet.getDouble("rate");
            int categoryName = resultSet.getInt("category");
            productList.add(Objects.requireNonNull(Objects.requireNonNull(createProductCreator(categoryName))
                    .createProduct(nameProduct, price, rate,categoryName)));
        }
        connection.close();
        return productList;
    }

    private static List<Category> getDBCategories() throws SQLException {
        connectoinDB();
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String category_name = resultSet.getString("category_name");
            int id = resultSet.getInt("category_id");
            categoryList.add(Objects.requireNonNull(createCategoryCreator(id)).createCategory(id, category_name));
        }
        connection.close();
        return categoryList;
    }

    private static ProductCreator createProductCreator(int categoryName){
        switch (categoryName){
            case 2:
                 return new BookCreator();
            case 3:
                 return new CatCreator();
            case 4:
                return new DogCreator();
            case 1:
                return new FoodCreator();
            default:
                return null;
        }
    }

    private static CategoryCreator createCategoryCreator(int id){
        switch (id){
            case 2:
                return new CategoryBookCreator();
            case 3:
                return new CategoryCatCreator();
            case 4:
                return new CategoryDogCreator();
            case 1:
                return new CategoryFoodCreator();
            default:
                return null;
        }
    }
}
