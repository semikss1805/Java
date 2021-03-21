package lab32.store;

import java.io.Serializable;
import java.util.Arrays;

public class AbstractStore implements Serializable {
    protected int count = 0;
    protected Object[] arr = new Object[count];

    public int getCount() {
        return count;
    }

    public Object[] getArr() {
        return arr;
    }

    protected void add(Object newProduct) {
        if (arr.length <= 2) {
            arr = Arrays.copyOf(arr, count + 1);
        }
        if (arr.length == count) {
            arr = Arrays.copyOf(arr, count + count/2);
        }
        arr[count++] = newProduct;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }
}
