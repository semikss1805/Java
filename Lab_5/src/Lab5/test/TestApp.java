package Lab5.test;

import Lab5.model.*;
import Lab5.store.ProductStore;
import Lab5.store.WoodDirectory;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Predicate;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public void startApp() {
        wd.add(new Wood(0, "0", 1));
        wd.add(new Wood(1, "1", 2));
        wd.add(new Wood(2, "2", 3));
        try {
            ps.add(new Timber(wd.get(0), 5f, 0.5f, 0.4f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.add(new Timber(wd.get(1), 3f, 0.5f, 0.4f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.add(new Timber(wd.get(1), 3f, 0.5f, 0.4f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.add(new Waste(40));
            ps.add(new Waste(55));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.add(new Cylinder(wd.get(2), 2, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(wd);
        System.out.println("До видалення");
        System.out.println(ps);
        System.out.printf("Загальна вага: %1.3f\n\n", calcWeight());

        System.out.println("Відходи вагою більше ніж 50");
        ps.doOnlyFor(
                (t)-> t instanceof Waste && ((IWeight) t).weight() > 50,
                System.out::println);
        float maxWeight = 50f;
        System.out.print("\nПісля видалення");
        ps.remove((t) -> t instanceof Waste && ((IWeight) t).weight() > maxWeight);
        System.out.println(ps.toString());
        wd.doForAll(System.out::println);
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

