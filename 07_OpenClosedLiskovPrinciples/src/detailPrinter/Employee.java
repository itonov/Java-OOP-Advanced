package detailPrinter;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}
