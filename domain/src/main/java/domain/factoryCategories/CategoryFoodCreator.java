package domain.factoryCategories;

import domain.Category;
import domain.categories.Food;

public class CategoryFoodCreator extends CategoryCreator {
    @Override
    public Category createCategory(int id, String categoryName) {
        return new Food(id, categoryName);
    }
}
