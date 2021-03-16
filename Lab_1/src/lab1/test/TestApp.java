package lab1.test;

import lab1.model.Timber;
import lab1.store.ProductStore;
import lab1.store.WoodDirectory;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public void startApp() {
        ps.add(new Timber(wd.get(0), 5f, 0.5f, 0.4f));
        ps.add(new Timber(wd.get(1), 10f, 0.5f, 0.4f));
        System.out.println(wd);
        System.out.println(ps);
        System.out.printf("Загальна вага: %1.3f\n", calcWeight());
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Timber timber : ps.getArr()) {
            fullWeight += timber.weight();
        }
        return fullWeight;
    }
}

