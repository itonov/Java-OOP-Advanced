package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> sold;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.sold = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(Enum.valueOf(CoffeeType.class, type.toUpperCase()),
                Enum.valueOf(CoffeeSize.class, size.toUpperCase()));
        int availableMoney = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (coffee.getPrice() <= availableMoney) {
            this.sold.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        this.coins.add(Enum.valueOf(Coin.class, coin));
    }

    public Iterable<Coffee> coffeesSold() {
        return this.sold;
    }
}
