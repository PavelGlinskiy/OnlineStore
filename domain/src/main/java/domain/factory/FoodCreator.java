package domain.factory;

import domain.Product;
import domain.products.Food;

public class FoodCreator extends Creator {

    @Override
    public Product createProduct() {
        return new Food(faker.book().title()
                ,faker.number().randomDouble(1,1,50)
                ,faker.number().randomDouble(1,1,10));
    }
}
