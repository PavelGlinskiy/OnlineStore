package domain.factoryProducts;

import domain.Product;
import domain.products.Food;

public class FoodCreator extends ProductCreator {


    @Override
    public Product createProduct(String nameProduct, double price, double rate, int id) {
        return new Food(nameProduct, price, rate, id);
    }
}
