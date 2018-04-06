package foodShortage;

public abstract class BasePerson implements Buyer {
    private String name;
    private int age;
    private int food;

    BasePerson(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = 0;
    }

    void CitizenBuyFood() {
        this.food += 10;
    }

    void RebelBuyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public abstract void buyFood();
}
