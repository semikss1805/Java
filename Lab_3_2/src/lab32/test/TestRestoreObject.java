package lab32.test;

import lab32.store.WoodDirectory;

import java.io.*;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = null;
        File f = new File("wd.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wd != null) {
            for (Object w : wd.getArr()) {
                System.out.println(w.toString());
            }
        }
    }
}
