package lab2.test;

import lab2.model.*;
import lab2.store.ProductStore;
import lab2.store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {
    private final WoodDirectory wd = new WoodDirectory();
    private final ProductStore ps = new ProductStore();
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
                case 1 -> addWood();
                case 2 -> addTimber();
                case 3 -> addCylinder();
                case 4 -> addWaste();
                case 5 -> calcWeight();
                case 6 -> {
                    System.out.println(wd);
                    System.out.println(ps);
                    calcWeight();
                    return;
                }
                default -> throw new IllegalStateException("Unexpected value: " + inputNum);
            }
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
        ps.add(new Waste(weight));
        System.out.println("Додано до списка");
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

            ps.add(new Cylinder(wd.get(id), length, diameter));
            System.out.println("Додано до списка");
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

            ps.add(new Timber(wd.get(id), length, height, width));
            System.out.println("Додано до списка");
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
