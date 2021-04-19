package Lab6.model;

public class Cylinder extends AbstractForm{
    private float length;
    private float diameter;

    public Cylinder(Wood wood,float length, float diameter) throws Exception {
        super(wood);
        if (length < 0.5 || length > 5.0) {
            throw new Exception("length=" + length + " is not correct!\n" + "Must be from 0.5 to 5.0");
        }
        if (diameter < 0.1 || diameter > 2.5) {
            throw new Exception("diameter=" + diameter + " is not correct!\n" + "Must be from 0.1 to 2.5");
        }
        this.length = length;
        this.diameter = diameter;
    }

    @Override
    public float volume() {
    return (float) (Math.PI * diameter * diameter * length);
    }

    public float getLength() {
        return length;
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "wood=" + wood.getName() +
                ", length=" + length +
                ", diameter=" + diameter +
                ", weight=" + weight() +
                '}';
    }
}
