package coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        CoffeeMachine cm = new CoffeeMachine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            if (tokens.length == 1) {
                cm.insertCoin(tokens[0]);
            } else {
                String size = tokens[0];
                String type = tokens[1];

                cm.buyCoffee(size, type);
            }
            input = reader.readLine();
        }

        Iterable<Coffee> result = cm.coffeesSold();
        for (Coffee coffee : result) {
            System.out.println(coffee);
        }
    }
}
