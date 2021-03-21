package lab32.test;

import lab32.model.*;
import lab32.store.ProductStore;
import lab32.store.WoodDirectory;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class TestByConsole {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();
    private Scanner in = new Scanner(System.in);

    public void startApp() {
        while (true) {
            System.out.println("\n1. Додати деревину");
            System.out.println("2. Додати брус");
            System.out.println("3. Додати круглий брус");
            System.out.println("4. Додати мішок із залишками виробництва");
            System.out.println("5. Підрахувати загальну вагу");
            System.out.println("6. Завершити роботу");
            Scanner in = new Scanner(System.in);
            int inputNum = in.nextInt();

            switch (inputNum) {
                case 1:
                    addWood();
                    break;
                case 2:
                    addTimber();
                    break;
                case 3:
                    addCylinder();
                    break;
                case 4:
                    addWaste();
                    break;
                case 5:
                    calcWeight();
                    break;
                case 6:
                    save();
                    break;
                case 7:
                    load();
                    break;
                case 8:
                    toTxt();
                case 9:
                    System.out.println(wd);
                    System.out.println(ps);
                    calcWeight();
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputNum);
            }
        }
    }

    private void toTxt() {
        JFileChooser dialog = new JFileChooser();
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if (f != null) {
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(wd.toString());
            writer.newLine();
            writer.write(ps.toString());
            writer.close();
            System.out.println("Виконано");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() {
        File f = new File("wd.object");
        File ff = new File("ps.object");
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

        try {
            FileInputStream fis = new FileInputStream(ff);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ps = (ProductStore) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ps != null) {
            for (Object p : ps.getArr()) {
                System.out.println(p.toString());
            }
        }
        System.out.println("Завантажено");
    }

    private void save() {
        File f = new File("wd.object");
        File ff = new File("ps.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream(ff);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ps);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calcWeight() {
        float fullWeight = 0;
        for (Object timber : ps.getArr()) {
            fullWeight += ((IWeight)timber).weight();
        }
        System.out.printf("Загальна вага: %1.3f", fullWeight);
    }

    private void addWaste() {
        float weight;
        System.out.println("Введіть вагу залишків виробництва");
        weight = in.nextFloat();
        try {
            ps.add(new Waste(weight));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Додано до списка");
        }
    }

    private void addCylinder() {
        int id;
        float length, diameter;
        System.out.println("Введіть інформацію наступним чином: idOfKindOfWood length diameter");
        String[] inf = in.nextLine().trim().split(" ");
        id = Integer.parseInt(inf[0]);
        if (wd.get(id) == null) {
            System.out.println("id = " + id + " не існує");
        } else {
            length = Float.parseFloat(inf[1]);
            diameter = Float.parseFloat(inf[2]);

            try {
                ps.add(new Cylinder(wd.get(id), length, diameter));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Додано до списка");
            }
        }
    }

    private void addTimber() {
        int id;
        float length, height, width;
        System.out.println("Введіть інформацію наступним чином: idOfKindOfWood length height width");
        String[] inf = in.nextLine().trim().split(" ");
        id = Integer.parseInt(inf[0]);
        if (wd.get(id) == null) {
            System.out.println("id = " + id + " не існує");
        } else {
            length = Float.parseFloat(inf[1]);
            height = Float.parseFloat(inf[2]);
            width = Float.parseFloat(inf[3]);

            try {
                ps.add(new Timber(wd.get(id), length, height, width));
                System.out.println("Додано до списка");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addWood() {
        System.out.println("Введіть інформацію наступним чином: id kindOfWood density");
        String inputString = in.nextLine();
        String[] inputInf = inputString.trim().split(" ");
        int id = Integer.parseInt(inputInf[0]);
        String kindOfWood = inputInf[1];
        float density = Float.parseFloat(inputInf[2]);
        Wood w = new Wood(id, kindOfWood, density);
        if (wd.add(w)) {
            System.out.println("Додано до списка");
        } else {
            System.out.println(w + " id вже існує\n");
        }
    }

    public static void main(String[] args) {
        TestByConsole app = new TestByConsole();
        app.startApp();
    }
}
