package borderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;

    Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
