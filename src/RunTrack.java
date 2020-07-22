public class RunTrack extends Obstacles {

    public RunTrack(float value, String type) {
        super(value, type);
    }

    @Override
    public boolean isItPossibleToDo(Competitive competitive) {
        competitive.run();
        if (this.value <= competitive.getRunVal()) {
            return true;
        } else {
            return false;
        }
    }

}


