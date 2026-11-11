package iscot.events;

import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent {

    public LightSensorEvent(Areas area, double light) {
        super(area, light);
        if (!Double.isFinite(light) || light < 0) {
            throw new IllegalArgumentException(
                "A luminosidade deve ser um valor finito e não negativo."
            );
        }
    }

    public double getLight() {
        return getValue();
    }

    @Override
    public String toString() {
        return "LightSensorEvent [light=" + getValue() + ", area=" + getArea() + ", type=" + getType() + "]";
    }
}
