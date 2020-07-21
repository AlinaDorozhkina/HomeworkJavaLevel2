public class Robot implements Competitive{
    private String name;
    private float runVal;
    private float jumpVal;
    private boolean result=true;

    public Robot (){
        this.name="Model L200j562472";
        this.runVal=15000.0f;
        this.jumpVal=3.0f;
    }

    public Robot(String name, float runVal, float jumpVal) {
        this.name = name;
        this.runVal = runVal;
        this.jumpVal = jumpVal;
    }

    public void run() {
        System.out.println(String.format("[%s может пробежать %.2f метров ]", name, runVal ));

    }


    public void jump() {
        System.out.println(String.format("[%s может прыгнуть %.2f метра ]", name, jumpVal ));

    }

    public String getName() {
        return name;
    }

    @Override
    public void setResult(boolean result) {
        this.result=result;
    }

    @Override
    public boolean getResult() {
        return result;
    }


    @Override
    public float getRunVal() {
        return runVal;
    }

    public float getJumpVal() {
        return jumpVal;
    }


}

