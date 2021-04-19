package Lab4.model;

public class Waste implements IWeight {
    private double weight;

    public Waste(double weight) throws Exception {
        if (weight < 0.1 || weight > 8) {
            throw new Exception("weight=" + weight + " is not correct!\n" + "Must be from 0.1 to 8");
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }

    public double weight() {
        return weight;
    }
}
