package iscot.events;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent{
     private final double temperature;

    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area);
        if (!Double.isFinite(temperature)) {
            throw new IllegalArgumentException(
                "A temperatura deve ser um valor finito."
            );
        }
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString(){
        return "TemperatureSensorEvent [temperature =" + temperature + ", area =" + getArea() + ", type=" + getType() + "]";
    }
}
