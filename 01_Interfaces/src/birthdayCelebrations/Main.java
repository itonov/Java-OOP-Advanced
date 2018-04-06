package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        List<Birthable> animals = new ArrayList<>();

        while (!"end".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String name = tokens[1];
            switch (tokens[0]) {
                case "Citizen":
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthday = tokens[4];
                    animals.add(new Citizen(name, age, id, birthday));
                    break;
                case "Pet":
                    birthday = tokens[2];
                    animals.add(new Pet(birthday, name));
                    break;
                default:
                    break;
            }
            inputLine = reader.readLine();
        }

        String neededYear = reader.readLine();
        for (Birthable animal : animals) {
            if (animal.getBirthDate().endsWith(neededYear)) {
                System.out.println(animal.getBirthDate());
            }
        }
    }
}
