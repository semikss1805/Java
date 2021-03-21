package lab32.model;

public abstract class AbstractForm implements IWeight {
    protected Wood wood;

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public Wood getWood() {
        return wood;
    }

    public float weight() {
        return wood.getDensity() * volume();
    }

    abstract float volume();
}
