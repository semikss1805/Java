package lab3.model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) throws Exception {
        if (weight < 0.020 || weight > 0.100) {
            throw new Exception("weight=" + weight + " is not correct!\n" + "Must be from 0.020 to 0.100");
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }

    public float weight() {
        return weight;
    }
}
