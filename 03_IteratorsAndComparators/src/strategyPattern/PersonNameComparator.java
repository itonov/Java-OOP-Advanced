package strategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getName().length() == person2.getName().length()) {
            return Character.compare(Character.toLowerCase(person1.getName().charAt(0)),
                    Character.toLowerCase(person2.getName().charAt(0)));
        } else {
            return Integer.compare(person1.getName().length(), person2.getName().length());
        }
    }
}
