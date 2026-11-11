package iscot.events;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent{

    private final boolean isOn;

    public AreaVentilationOrderEvent(Areas area, boolean isOn){
        super(area);
        this.isOn = isOn;
    }

    public boolean isOn(){
        return isOn;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [area=" + getArea() + ", type=" + getType() + ", isOn=" + getIsOn() +"]";
    }
}
    
