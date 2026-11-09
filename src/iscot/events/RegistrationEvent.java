package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event {

    public RegistrationEvent(Areas area, Type type) {
        super(area, type);
        
    }
    
}
