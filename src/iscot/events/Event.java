package iscot.events;

import java.io.Serializable;
import java.util.UUID;

/**
 * Superclasse abstrata de todos os eventos no sistema IscoT.
 * Implementa Serializable para permitir o envio por canais de objetos (ObjectStream).
 */
public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String eventId;
    private final long timestamp;

    public Event() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public Event(String eventId, long timestamp) {
        this.eventId = eventId;
        this.timestamp = timestamp;
    }

    public String getEventId() {
        return eventId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + eventId + ", timestamp=" + timestamp + "]";
    }
}
