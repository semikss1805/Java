package lab2.store;

import lab2.model.AbstractForm;
import lab2.model.IWeight;
import lab2.model.Timber;

import java.util.Arrays;

public class ProductStore extends AbstractStore{
    public void add(IWeight newProduct) {
        super.add(newProduct);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Вміст сховища продуктів \n");
        sb.append(super.toString());
        return sb.toString();
    }
}
