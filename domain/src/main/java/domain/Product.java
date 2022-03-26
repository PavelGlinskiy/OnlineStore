package domain;

public class Product {
    private String nameProduct;
    private double price;
    private double rate;

    public Product(String nameProduct, double price, double rate) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "\t\tProduct Name: \"" + nameProduct + "\". Price: " + price + "$. Rate: " + rate + "$.\n" ;
    }

}
