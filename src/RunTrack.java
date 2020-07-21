public class RunTrack extends Obstacles {

    public RunTrack(float value, String type) {
        super(value, type);
    }


    public float getValue() {
        return value;
    }


    @Override
    public boolean isItPossibleToDo(Competitive competitive) {
        competitive.run();
        if (this.value <= competitive.getRunVal()) {

            competitive.setResult(true);

            return true;
        } else {

            competitive.setResult(false);

            return false;
        }
    }

}


