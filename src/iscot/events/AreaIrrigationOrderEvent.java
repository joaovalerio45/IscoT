package iscot.events;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent{
    private final boolean state;
    private final int zona;
    private final int duracao;

    public AreaIrrigationOrderEvent(Areas area, boolean state, int zona, int duracao) {
        if (zona < 1 || zona > 3) {
            throw new IllegalArgumentException("A zona deve ser 1, 2 ou 3.");
        }

        if (duracao < 0) {
            throw new IllegalArgumentException("A duração não pode ser negativa.");
        }
        super(area);
        this.state = state;
        this.zona = zona;
        this.duracao = duracao;
    }

    public boolean getState() {
        return state;
    }

    public int getZona() {
        return zona;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override 
    public String toString() {
        return "AreaIrrigationOrderEvent [ state= " + state + ", zona=" + zona + ",duracao = " + duracao + ",area= " + getArea() + ",type=" + getType() + "]";
    }
}
