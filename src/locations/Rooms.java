package locations;

import entity.Unfixed;

import java.util.ArrayList;

public abstract class Rooms extends World{
    protected Rooms() {
        super("Комната");
    }
    ArrayList<Unfixed> operands = new ArrayList<>();
    public void setOperands(Unfixed entity) {
        if ((!operands.contains(entity)) && (entity.getMobility())) {
            operands.add(entity);
        }
    }
    public ArrayList<Unfixed> getOperands() {
        return operands;
    }
}

