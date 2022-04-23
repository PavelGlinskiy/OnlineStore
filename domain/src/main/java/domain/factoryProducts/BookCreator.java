package domain.factoryProducts;

import domain.products.Book;

public class BookCreator extends ProductCreator {



    @Override
    public Book createProduct(String nameProduct, double price, double rate, int id) {
        return new Book(nameProduct, price, rate, id);
    }
}
