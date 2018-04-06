package dependency_inversion;

import dependency_inversion.strategies.AdditionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        PrimitiveCalculator calculator = new PrimitiveCalculator(new AdditionStrategy());

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equalsIgnoreCase("mode")) {
                char operator = tokens[1].charAt(0);
                calculator.changeStrategy(operator);
            } else {
                System.out.println(calculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
            input = reader.readLine();
        }
    }
}
