package domain.factoryCategories;

import domain.Category;
import domain.categories.Cat;

public class CategoryCatCreator extends CategoryCreator {
    @Override
    public Category createCategory(int id, String categoryName) {
        return new Cat(id, categoryName);
    }
}
