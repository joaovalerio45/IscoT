package iscot.events;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent {

    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area, temperature);
        if (!Double.isFinite(temperature)) {
            throw new IllegalArgumentException(
                "A temperatura deve ser um valor finito."
            );
        }
    }

    public double getTemperature() {
        return getValue();
    }

    @Override
    public String toString() {
        return "TemperatureSensorEvent [temperature=" + getValue() + ", area=" + getArea() + ", type=" + getType() + "]";
    }
}
