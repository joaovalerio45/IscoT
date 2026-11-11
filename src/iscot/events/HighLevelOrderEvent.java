package iscot.events;

import iscot.enums.Type;
import iscot.enums.Areas;

public abstract class HighLevelOrderEvent extends Event{
      
    public HighLevelOrderEvent(Areas area) {
        super(area, Type.DECIDER);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [area=" + getArea() + ", type=" + getType() + "]";
    }
}
