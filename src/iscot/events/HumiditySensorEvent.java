package iscot.events;

import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent {

    public HumiditySensorEvent(Areas area, double humidity) {
        super(area, humidity);
        if (!Double.isFinite(humidity) || humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException(
                "A humidade do ar deve ser um valor finito entre 0 e 100."
            );
        }
    }

    public double getHumidity() {
        return getValue();
    }

    @Override
    public String toString() {
        return "HumiditySensorEvent [humidity=" + getValue() + ", area=" + getArea() + ", type=" + getType() + "]";
    }
}
