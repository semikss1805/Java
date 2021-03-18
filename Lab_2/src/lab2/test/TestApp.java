package lab2.test;

import lab2.model.*;
import lab2.store.ProductStore;
import lab2.store.WoodDirectory;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public void startApp() {
        wd.add(new Wood(0, "0", 1));
        wd.add(new Wood(1, "1", 2));
        wd.add(new Wood(2, "2", 3));
        ps.add(new Timber(wd.get(0), 5f, 0.5f, 0.4f));
        ps.add(new Timber(wd.get(1), 10f, 0.5f, 0.4f));
        ps.add(new Waste(23));
        ps.add(new Cylinder(wd.get(2), 2, 3));
        System.out.println(wd);
        System.out.println(ps);
        System.out.printf("Загальна вага: %1.3f\n", calcWeight());
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

