package lab3.model;
public class Timber extends AbstractForm {
    private float length;
    private float heigth;
    private float width;

    public Timber(Wood wood, float length, float height, float width) throws Exception {
        super(wood);
        if (length < 0.5 || length > 5.0) {
            throw new Exception("length=" + length + " is not correct!\n" + "Must be from 0.5 to 5.0");
        }
        if (height < 0.1 || height > 0.5) {
            throw new Exception("heigth=" + height + " is not correct!\n" + "Must be from 0.1 to 0.5");
        }
        if (width < 0.1 || width > 0.5) {
            throw new Exception("width=" + width + " is not correct!\n" + "Must be from 0.1 to 0.5");
        }
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