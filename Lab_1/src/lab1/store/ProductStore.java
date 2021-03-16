package lab1.store;

import lab1.model.Timber;

import java.util.Arrays;

public class ProductStore {
    private int count = 0;
    private Timber[] arr = new Timber[count];

    public int getCount() {
        return count;
    }

    public Timber[] getArr() {
        return arr;
    }

    public void add(Timber newTimber) {
        if (arr.length <= 2) {
            arr = Arrays.copyOf(arr, count + 1);
        }
        if (arr.length == count) {
            arr = Arrays.copyOf(arr, count + count/2);
        }
        arr[count++] = newTimber;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог брусків \n");
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }
}
