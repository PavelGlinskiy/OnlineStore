package domain.factoryCategories;

import domain.Category;
import domain.categories.Book;

public class CategoryBookCreator extends CategoryCreator {
    @Override
    public Category createCategory(int id, String categoryName) {
        return new Book(id, categoryName);
    }
}
