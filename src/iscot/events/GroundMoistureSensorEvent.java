package iscot.events;

import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent {

    public GroundMoistureSensorEvent(Areas area, double groundMoisture) {
        super(area, groundMoisture);
        if (!Double.isFinite(groundMoisture) || groundMoisture < 0 || groundMoisture > 100) {
            throw new IllegalArgumentException(
                "A humidade do solo deve ser um valor finito entre 0 e 100."
            );
        }
    }

    public double getGroundMoisture() {
        return getValue();
    }

    @Override
    public String toString() {
        return "GroundMoistureSensorEvent [groundMoisture=" + getValue() + ", area=" + getArea() + ", type=" + getType() + "]";
    }
}
