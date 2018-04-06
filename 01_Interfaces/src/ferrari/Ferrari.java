package ferrari;

public class Ferrari implements Car {
    private static final String MODEL = "488-Spider";
    private String driver;

    Ferrari(String driver) {
        this.driver = driver;
    }

    public String getMODEL() {
        return MODEL;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }
}
