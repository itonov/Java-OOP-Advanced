package equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> treeSet = new TreeSet<>(new PersonComparator());
        Set<Person> hashSet = new HashSet<>();

        int linesCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < linesCount; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            treeSet.add(new Person(name, age));
            hashSet.add(new Person(name, age));
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
