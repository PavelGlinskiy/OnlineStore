package domain.factory;

import domain.Product;
import domain.products.Dog;

public class DogCreator extends Creator{

    @Override
    public Product createProduct() {
        return new Dog(faker.book().title()
                ,faker.number().randomDouble(1,1,300)
                ,faker.number().randomDouble(1,1,30));
    }

}
