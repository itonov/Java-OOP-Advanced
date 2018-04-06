package multipleImplementation;

public class Citizen implements Person, Birthable, Identifiable {
    private int age;
    private String name;
    private String birthdate;
    private String id;

    Citizen(String name, int age, String id, String birthdate) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
