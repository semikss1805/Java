package Lab4.test;

import Lab4.model.Wood;
import Lab4.store.WoodDirectory;

import java.io.*;

public class TestStoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();
        wd.add(new Wood(1, "Дуб", 1f));
        File f = new File("wd.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
