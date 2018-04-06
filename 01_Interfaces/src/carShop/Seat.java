package carShop;

public class Seat implements Sellable {
    private String countryProduced;
    private String model;
    private String color;
    private int horsePower;
    private double price;

    Seat(String model, String color, int horsePower, String countryProduced, double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.getModel(),
                this.countryProduced,
                this.TIRES);
    }
}
