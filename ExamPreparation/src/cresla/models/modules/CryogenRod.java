package cresla.models.modules;

public class CryogenRod extends AbstractEnergyModule {

    public CryogenRod(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public String toString() {
        return String.format("CryogenRod Module - %d\r\nEnergy Output: %d", super.getId(), super.getEnergyOutput());
    }
}
