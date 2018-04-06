package birthdayCelebrations;

public abstract class BaseAnimal implements Birthable {
    private String birthDate;
    private String name;

    BaseAnimal(String birthDate, String name) {
        this.birthDate = birthDate;
        this.name = name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
