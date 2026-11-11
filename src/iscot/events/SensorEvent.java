package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class SensorEvent extends Event {

    private final double value;

    public SensorEvent(Areas area, double value) {
        super(area, Type.SENSOR);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [value=" + value + ", area=" + getArea() + ", type=" + getType() + "]";
    }
}
