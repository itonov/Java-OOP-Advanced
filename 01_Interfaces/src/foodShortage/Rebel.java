package foodShortage;

public class Rebel extends BasePerson {
    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood() {
        super.RebelBuyFood();
    }
}
