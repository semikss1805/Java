package Lab4.test;

import Lab4.model.*;
import Lab4.store.ProductStore;
import Lab4.store.WoodDirectory;

import java.util.Iterator;
import java.util.ListIterator;

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
            ps.add(new Waste(0.2));
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
        System.out.printf("Загальна вага: %1.3f\n", calcWeight());

        System.out.println("Після видалення");
        Iterator<Object> itr = ps.iterator();
        while (itr.hasNext()) {
            IWeight obj = (IWeight) itr.next();
            if (obj.weight() > 1.1) itr.remove();
        }
        System.out.println(ps.toString());

        ListIterator<Object> listItr = ps.listIterator();
        while (listItr.hasNext()) {
            listItr.next();
        }
        listItr.previous();
                try {
                    listItr.add(new Timber(wd.get(1), 3f, 0.5f, 0.4f));
                } catch (Exception e) {
                    e.printStackTrace();
                }


        System.out.println("Після Додавання");
        System.out.println(ps.toString());

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

