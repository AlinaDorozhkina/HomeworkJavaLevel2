public class Wall extends Obstacles{


    public Wall() {
        super(5.0f,"Wall");
    }

    @Override
    protected boolean isItPossibleToDo(Competitive competitive) {

        competitive.jump();
        if (this.value <= competitive.getJumpVal()) {
            System.out.println("Участник " + competitive.getName()+" перепрыгнул стену");
            competitive.setResult(true);

            return true;
        } else {
            System.out.println("Участник " + competitive.getName()+" не смог перепрыгнуть стену");
            competitive.setResult(false);

            return false;
        }
    }

    public float getValue() {
        return value;
    }
}


