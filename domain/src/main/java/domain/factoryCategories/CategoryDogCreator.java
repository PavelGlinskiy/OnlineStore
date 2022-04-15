package domain.factoryCategories;

import domain.Category;
import domain.categories.Dog;

public class CategoryDogCreator extends CategoryCreator {
    @Override
    public Category createCategory(int id, String categoryName) {
        return new Dog(id, categoryName);
    }
}
