package lab1.test;

import lab1.model.Timber;
import lab1.model.Wood;
import lab1.store.ProductStore;
import lab1.store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {
    private final WoodDirectory wd = new WoodDirectory();
    private final ProductStore ps = new ProductStore();

    public void startApp() {
        while (true) {
            System.out.println("\n1. Додати деревину");
            System.out.println("2. Додати брус");
            System.out.println("3. Підрахувати загальну вагу");
            System.out.println("4. Завершити роботу");
            Scanner in = new Scanner(System.in);
            int inputNum = in.nextInt();

            switch (inputNum) {
                case 1 -> addWood();
                case 2 -> addTimber();
                case 3 -> calcWeight();
                case 4 -> {
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
        for (Timber timber : ps.getArr()) {
            fullWeight += timber.weight();
        }
        System.out.printf("Загальна вага: %1.3f", fullWeight);
    }

    private void addTimber() {
        Scanner in = new Scanner(System.in);
        int id;
        float length, height, width;

        System.out.println("Введіть інформацію наступним чином: idOfKindOfWood length height width");
        String[] inf = in.nextLine().trim().split(" ");

        id = Integer.parseInt(inf[0]);
        if (wd.get(id) == null) {
            System.out.println("id = " + id + " не існує");
            return;
        }
        length = Float.parseFloat(inf[1]);
        height = Float.parseFloat(inf[2]);
        width = Float.parseFloat(inf[3]);

        ps.add(new Timber(wd.get(id), length, height, width));
        System.out.println("Додано до списка");
    }

    private void addWood() {
        Scanner in = new Scanner(System.in);
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
            System.out.println(w + " вже існує\n");
        }
    }
}
