package kings_gambit.models;

public abstract class AbstractUnit {
    private String name;

    public AbstractUnit(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
