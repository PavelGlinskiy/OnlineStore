package domain.factory;

import domain.Product;
import domain.products.Cat;

public class CatCreator extends Creator {

    @Override
    public Product createProduct() {
        return new Cat(faker.book().title()
                ,faker.number().randomDouble(1,1,200)
                ,faker.number().randomDouble(1,1,20));
    }
}
