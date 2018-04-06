package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new PersonAgeComparator());

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            peopleByName.add(new Person(name, age));
            peopleByAge.add(new Person(name, age));
        }

        for (Person person : peopleByName) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        for (Person person : peopleByAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
