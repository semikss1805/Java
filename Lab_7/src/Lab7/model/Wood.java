package Lab7.model;

import java.io.Serializable;
import java.util.Objects;

public class Wood implements Serializable {
    private int id;
    private String name;
    private float density;

    public Wood(int id, String name, float density) {
        this.id = id;
        this.name = name;
        this.density = density;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDensity() {
        return density;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wood wood = (Wood) o;
        return id == wood.id && Float.compare(wood.density, density) == 0 && Objects.equals(name, wood.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, density);
    }

    @Override
    public String toString() {
        return "Wood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", density=" + density +
                '}';
    }
}
