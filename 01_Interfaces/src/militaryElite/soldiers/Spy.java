package militaryElite.soldiers;

public class Spy extends Soldier implements ISpy {
    private int codeNum;

    public Spy(int id, String firstName, String lastName, int codeNum) {
        super(id, firstName, lastName);
        this.codeNum = codeNum;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNum;
    }

    @Override
    public String toString() {
        return String.format("%s %d", super.toString(), this.getCodeNumber());
    }
}
