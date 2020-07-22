public class Human implements Competitive {
    private String name;
    private float runVal;
    private float jumpVal;


    public Human() {
        this.name = "Ivan";
        this.runVal = 10000.0f;
        this.jumpVal = 10.0f;
    }

    public Human(String name, float runVal, float jumpVal) {
        this.name = name;
        this.runVal = runVal;
        this.jumpVal = jumpVal;
    }


    @Override
    public void run() {
        System.out.println(String.format("[%s может пробежать %.2f метров]", name, runVal));

    }

    @Override
    public void jump() {
        System.out.println(String.format("[%s может прыгнуть %.2f метра]", name, jumpVal));

    }

    public String getName() {
        return name;
    }

    public float getRunVal() {
        return runVal;
    }

    public float getJumpVal() {
        return jumpVal;
    }


}

