package iscot.events;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent{

    private final AirConditioningMode mode;
    private final double targetTemperature;


    // para modo Frio ou Quente (temperatura objetivo)
    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double targetTemperature) {
        super(area);
        this.mode = mode;
        this.targetTemperature = targetTemperature;
    }

    // para modo ventilação ou desligado(sem temperatura objetivo)
    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode) {
        this(area, mode, -1);
    }

    public AirConditioningMode getMode(){
        return mode;
    }

    public double getTargetTemperature(){
        return targetTemperature;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [area=" + getArea() + ", type=" + getType() + ", mode=" + getMode() + ", targetTemperature=" + getTargetTemperature() + "]";
    }
}
