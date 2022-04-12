package domain.factory;

import domain.Product;
import domain.products.Book;

public class BookCreator extends Creator {

    @Override
    public Product createProduct() {
        return new Book(faker.book().title()
                ,faker.number().randomDouble(1,1,100)
                ,faker.number().randomDouble(1,1,10));
    }
}
