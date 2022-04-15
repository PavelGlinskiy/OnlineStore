package domain.factoryCategories;

import domain.Category;


public abstract class CategoryCreator {
    public abstract Category createCategory(int id, String categoryName);


}
