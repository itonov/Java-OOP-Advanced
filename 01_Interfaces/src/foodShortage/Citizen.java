package foodShortage;

public class Citizen extends BasePerson {
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public void buyFood() {
        super.CitizenBuyFood();
    }
}
