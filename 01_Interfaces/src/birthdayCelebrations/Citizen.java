package birthdayCelebrations;

class Citizen extends BaseAnimal {
    private int age;
    private String id;

    Citizen(String name, int age, String id, String birthDate) {
        super(birthDate, name);
        this.age = age;
        this.id = id;
    }
}
