package domain.factoryProducts;

import domain.Product;
import domain.products.Cat;

public class CatCreator extends ProductCreator {


    @Override
    public Product createProduct(String nameProduct, double price, double rate, int id) {
        return new Cat(nameProduct, price, rate, id);
    }
}
