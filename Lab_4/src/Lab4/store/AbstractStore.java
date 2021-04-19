package Lab4.store;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class AbstractStore implements Serializable, Iterable <Object> {
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
        for (Object obj : this) {
            sb.append(obj).append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<Object> iterator() {
        return new StoreIterator();
    }

    public ListIterator<Object> listIterator() {
        return new StoreListIterator();
    }

    private class StoreListIterator extends StoreIterator implements ListIterator<Object> {

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public Object previous() {
            return arr[current--];
        }

        @Override
        public int nextIndex() {
            return current + 1;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void set(Object o) {
            arr[current] = o;
        }

        @Override
        public void add(Object o) {
            if (current == arr.length - 1){
                arr = Arrays.copyOf(arr, arr.length + 1);
            }
            System.arraycopy(arr,current,arr, current + 1, count - current);
            arr[current] = o;
            current++;
            count++;
        }
    }


    private class StoreIterator implements Iterator<Object> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < count;
        }

        @Override
        public Object next() {
            return arr[current++];
        }

        @Override
        public void remove() {
            System.arraycopy(arr,current,arr,current-1 ,count - current);
            count--;
            current--;
        }
    }
}