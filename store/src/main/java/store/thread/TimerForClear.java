package store.thread;

import store.utility.BuyProducts;

import java.util.TimerTask;

public class TimerForClear extends TimerTask {
    @Override
    public void run() {
        BuyProducts.clearProducts();
    }
}
