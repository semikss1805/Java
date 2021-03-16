package lab1.model;
public class Timber {
    private Wood wood;
    private float length;
    private float heigth;
    private float width;

    public Timber(Wood wood, float length, float height, float width) {
        this.wood = wood;
        this.length = length;
        this.heigth = height;
        this.width = width;
    }

    public Wood getWood() {
        return wood;
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

    public float weight() {
        return wood.getDensity() * volume();
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