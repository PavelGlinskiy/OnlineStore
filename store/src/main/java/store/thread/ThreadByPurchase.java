package store.thread;


import store.utility.BuyProducts;

public class ThreadByPurchase implements Runnable {
    private String productName;

    public ThreadByPurchase(String productName) {
        this.productName = productName;
    }

    @Override
    public void run() {
       BuyProducts.purchase(productName);
    }
}
