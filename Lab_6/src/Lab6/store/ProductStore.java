package Lab6.store;

import Lab6.model.IWeight;

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
