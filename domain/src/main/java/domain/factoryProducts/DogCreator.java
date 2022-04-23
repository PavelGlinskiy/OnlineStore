package domain.factoryProducts;

import domain.Product;
import domain.products.Dog;

public class DogCreator extends ProductCreator {


    @Override
    public Product createProduct(String nameProduct, double price, double rate, int id) {
        return new Dog(nameProduct, price, rate, id);
    }
}
