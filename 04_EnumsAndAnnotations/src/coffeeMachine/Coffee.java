package coffeeMachine;

public class Coffee {
    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(CoffeeType type, CoffeeSize size) {
        this.type = type;
        this.size = size;
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size.name().charAt(0) + this.size.name().substring(1).toLowerCase() + " "
                + this.type.name().charAt(0) + this.type.name().substring(1).toLowerCase();
    }
}
