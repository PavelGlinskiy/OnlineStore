package domain.factoryProducts;

import domain.Product;

public abstract class ProductCreator {

    public abstract Product createProduct(String nameProduct, double price, double rate, int id);
}
