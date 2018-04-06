package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            people.add(new Person(name, age, town));
            input = reader.readLine();
        }

        int index = Integer.parseInt(reader.readLine()) - 1;
        Person neededPerson = people.get(index);
        int equalCount = 0;
        int diffCount = 0;

        for (Person person : people) {
            if (neededPerson.compareTo(person) == 0) {
                equalCount++;
            } else {
                diffCount++;
            }
        }
        if (equalCount <= 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalCount, diffCount, people.size());
        }
    }
}
