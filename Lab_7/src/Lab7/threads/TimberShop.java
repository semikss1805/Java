package Lab7.threads;

import Lab7.model.IWeight;
import Lab7.model.Timber;
import Lab7.model.Wood;
import Lab7.store.ProductStore;
import Lab7.store.WoodDirectory;

import java.util.Random;

public class TimberShop extends WoodShop {

    public TimberShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super(wd, ps, n, name);
    }
    public IWeight createProduct() {
        int woodId = rnd.nextInt(3) + 1;
        Wood wood = wd.get(woodId);
        float length = 1 + rnd.nextFloat() * 10;
        float height = 0.1f + rnd.nextFloat();
        float width = 0.1f + rnd.nextFloat();
        return new Timber(wood, length, height, width);
    }
}
