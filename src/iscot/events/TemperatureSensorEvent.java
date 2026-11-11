package iscot.events;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent {

    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area, temperature);
        if (!Double.isFinite(temperature) || temperature < 0 || temperature > 30) {
            throw new IllegalArgumentException(
                "A temperatura ambiente deve estar entre 0 °C e 30 °C."
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
