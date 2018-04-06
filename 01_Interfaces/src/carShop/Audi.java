package carShop;

public class Audi implements Rentable {
    private int minRentDay;
    private double pricePerDay;
    private String countryProduced;
    private String model;
    private String color;
    private int horsePower;

    Audi(String model, String color, int horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
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
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.model,
                this.countryProduced,
                this.TIRES);
    }
}
