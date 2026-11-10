package iscot.events;

import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent {
     private final double groundMoisture;

    public GroundMoistureSensorEvent(Areas area, double groundMoisture) {
        super(area);
        if (!Double.isFinite(groundMoisture) || groundMoisture < 0 || groundMoisture > 100) {
            throw new IllegalArgumentException(
                "A humidade do solo deve ser um valor finito entre 0 e 100."
            );
        }
        this.groundMoisture = groundMoisture;
    }

    public double getGroundMoisture() {
        return groundMoisture;
    }

    @Override
    public String toString(){
        return "GroundMoistureSensorEvent [ground moisture =" + groundMoisture + ", area =" + getArea() + ", type=" + getType() + "]";
    }
}
