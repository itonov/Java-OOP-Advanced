package equalityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getAge() == person2.getAge() && person1.getName().equals(person2.getName())) {
            return 0;
        } else {
            return Integer.compare(person1.getName().compareTo(person2.getName()), Integer.compare(person1.getAge(), person2.getAge()));
        }
    }
}
