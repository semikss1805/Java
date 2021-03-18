package lab2.model;
public class Timber extends AbstractForm {
    private float length;
    private float heigth;
    private float width;

    public Timber(Wood wood, float length, float height, float width) {
        super(wood);
        this.length = length;
        this.heigth = height;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public float getHeigth() {
        return heigth;
    }

    public float getWidth() {
        return width;
    }

    public float volume() {
        return length * heigth * width;
    }

    @Override
    public String toString() {
        return "Timber{" +
                "wood=" + wood.getName() +
                ", length=" + length +
                ", heigth=" + heigth +
                ", width=" + width +
                ", weight=" + weight() +
                '}';
    }
}