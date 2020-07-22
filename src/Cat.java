public class Cat implements Competitive {
    private String name;
    private float runVal;
    private float jumpVal;
    private boolean result=true;

    public Cat(String name, float runVal, float jumpVal) {
        this.name = name;
        this.runVal = runVal;
        this.jumpVal = jumpVal;
    }

    public Cat() {
        this.name = "Champion";
        this.runVal = 5000.0f;
        this.jumpVal = 5.5f;

    }


    @Override
    public void run() {
        System.out.println(String.format("[%s может пробежать %.2f метров]", name, runVal));

    }

    @Override
    public void jump() {
        System.out.println(String.format("[%s может прыгнуть на высоту %.2f метра]", name, jumpVal));

    }

    @Override
    public float getRunVal() {
        return runVal;
    }

    @Override
    public float getJumpVal() {
        return jumpVal;
    }

    public String getName() {
        return name;
    }


}
