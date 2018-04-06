package comparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.equalsIgnoreCase(person.name)) {
            if (this.age == person.age) {
                return this.town.compareTo(person.town);
            } else {
                return Integer.compare(this.age, person.age);
            }
        } else {
            return this.name.compareTo(person.name);
        }
    }
}
