package Lab7.threads;

import Lab7.model.Cylinder;
import Lab7.model.IWeight;
import Lab7.model.Timber;
import Lab7.model.Wood;
import Lab7.store.ProductStore;
import Lab7.store.WoodDirectory;

public class CylinderShop extends WoodShop{

    public CylinderShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super(wd, ps, n, name);
    }

    @Override
    protected IWeight createProduct() {
        int woodId = rnd.nextInt(3) + 1;
        Wood wood = wd.get(woodId);
        float length = 1 + rnd.nextFloat() * 10;
        float diameter = 0.1f + rnd.nextFloat();
        return new Cylinder(wood, length, diameter);
    }
}
