package Lab7.store;

import Lab7.model.Wood;

public class WoodDirectory extends AbstractStore {
    {
        add(new Wood(0, "0", 1));
        add(new Wood(1, "1", 2));
        add(new Wood(2, "2", 3));
        add(new Wood(3, "3", 4));
    }

    public Wood get(int id) {
        for (int i = 0; i < count; i++) {
            Wood wood = (Wood) arr[i];
            if (wood.getId() == id) {
                return wood;
            }
        }
        return null;
    }

    public boolean add(Wood newWood) {
        if (get(newWood.getId()) != null) {
            return false;
        }
        super.add(newWood);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог деревини: \n");
        sb.append(super.toString());
        return sb.toString();
    }
}
