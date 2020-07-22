public class Wall extends Obstacles {


    public Wall(float value, String type) {
        super(value, type);
    }

    @Override
    protected boolean isItPossibleToDo(Competitive competitive) {

        competitive.jump();
        if (this.value <= competitive.getJumpVal()) {
            return true;
        } else {
            return false;
        }
    }

}


