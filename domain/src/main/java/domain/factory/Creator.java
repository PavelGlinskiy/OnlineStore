package domain.factory;

import com.github.javafaker.Faker;
import domain.Product;

public abstract class Creator {
    protected Faker faker = new Faker();

    public abstract Product createProduct();
}
