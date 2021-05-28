package Lab7.test;

import Lab7.model.*;
import Lab7.store.ProductStore;
import Lab7.store.WoodDirectory;
import Lab7.threads.TimberShop;
import Lab7.threads.WoodShop;

public class TestApp {
    private final WoodDirectory wd = new WoodDirectory();
    private final ProductStore ps = new ProductStore();

    public void startApp() {
        WoodShop shop1 = new TimberShop("timberShop",wd,ps,1000);
        WoodShop shop2 = new TimberShop("cylinderShop",wd,ps,1000);
        Thread tshop1 = new Thread(shop1);
        Thread tshop2 = new Thread(shop2);
        tshop1.start();
        tshop2.start();
        try {
            tshop1.join();
            tshop2.join();
            System.out.println(ps.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Object timber : ps.getArr()) {
            fullWeight += ((IWeight)timber).weight();
        }
        return fullWeight;
    }

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();
    }
}

