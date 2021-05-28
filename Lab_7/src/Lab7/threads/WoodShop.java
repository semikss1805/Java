package Lab7.threads;

import Lab7.model.IWeight;
import Lab7.model.Timber;
import Lab7.model.Wood;
import Lab7.store.ProductStore;
import Lab7.store.WoodDirectory;

import java.util.Random;

public abstract class WoodShop implements Runnable {
    WoodDirectory wd;
    ProductStore ps;
    Random rnd = new Random();
    int n;
    String name;

    public WoodShop(WoodDirectory wd, ProductStore ps, int n, String name) {
        super();
        this.wd = wd;
        this.ps = ps;
        this.n = n;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract IWeight createProduct();

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            var shape = createProduct();
            System.out.println(this.getName() + " create " + shape);
            ps.add(shape);
        }
    }
}
