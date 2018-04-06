package cresla.models.modules;

public class HeatProcessor extends AbstractAbsorbingModule {

    public HeatProcessor(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public String toString() {
        return String.format("HeatProcessor Module - %d\r\nHeat Absorbing: %d", super.getId(), super.getHeatAbsorbing());
    }
}
