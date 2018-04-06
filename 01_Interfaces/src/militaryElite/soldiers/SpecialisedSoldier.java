package militaryElite.soldiers;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier{
    private String corps;

    SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append(String.format("Corps: %s", this.getCorps()));
        return sb.toString();
    }
}
