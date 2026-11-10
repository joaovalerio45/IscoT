package iscot.events;

import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent{
     private final double humidity;

    public HumiditySensorEvent(Areas area, double humidity) {
        super(area);
        if (!Double.isFinite(humidity) || humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException(
                "A humidade do ar deve ser um valor finito entre 0 e 100."
            );
        }
        this.humidity = humidity;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString(){
        return "HumiditySensorEvent [humidity =" + humidity + ", area =" + getArea() + ", type=" + getType() + "]";
    }
}
