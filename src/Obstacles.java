public abstract class Obstacles {
    protected float value;
    protected String type;

    public Obstacles(float value, String type) {
        this.value = value;
        this.type = type;
    }



    protected abstract boolean isItPossibleToDo(Competitive competitive);

    public float getValue() {
        return value;
    }
}

