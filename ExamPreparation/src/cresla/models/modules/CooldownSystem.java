package cresla.models.modules;

public class CooldownSystem extends AbstractAbsorbingModule {

    public CooldownSystem(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public String toString() {
        return String.format("CooldownSystem Module - %d\r\nHeat Absorbing: %d", super.getId(), super.getHeatAbsorbing());
    }
}
