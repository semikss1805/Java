package lab32.test;

import lab32.model.Wood;
import lab32.store.WoodDirectory;

import java.io.*;

public class TestStoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();
        wd.add(new Wood(4, "oak", 1f));
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
