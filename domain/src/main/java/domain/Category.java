package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String nameCategory;
    private List<Product> productList = new ArrayList<>();

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "\tCategory - " + nameCategory + "\n";
    }
}
