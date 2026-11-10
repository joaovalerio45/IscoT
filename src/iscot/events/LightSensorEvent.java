package iscot.events;
import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent{
    
    private final double light;

    public LightSensorEvent(Areas area, double light) {
        super(area);
        if (!Double.isFinite(light) || light < 0) {
            throw new IllegalArgumentException(
                "A luminosidade deve ser um valor finito e não negativo."
            );
        }
        this.light = light;
    }

    public double getLight() {
        return light;
    }


    @Override
    public String toString(){
        return "LightSensorEvent [light =" + light + ", area =" + getArea() + ", type=" + getType() + "]";
    }
}
