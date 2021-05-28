package Lab7.store;

import Lab7.model.IWeight;

public class ProductStore extends AbstractStore{
    private Object monitor = new Object();
    public void add(IWeight newProduct) {
        synchronized (monitor) {
            super.add(newProduct);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Вміст сховища продуктів \n");
        sb.append(super.toString());
        return sb.toString();
    }
}
