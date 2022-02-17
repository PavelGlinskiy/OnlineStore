package domain;

public class Product {
    private String nameProduct;
    private float price;
    private float rate;

    public Product(String nameProduct, float price, float rate) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.rate = rate;
    }

    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
}
