package locations;
import entity.Unfixed;
import java.util.ArrayList;

public abstract class World {
    private String name;
    public World(String name) {
        this.name = name;
    }

    public World() {
    }

    ArrayList<Unfixed> operands = new ArrayList<>();
    public String getLocName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setOperands(Unfixed entity) {
        if ((!operands.contains(entity)) && (entity.getMobility())) {
            operands.add(entity);
        }
    }
    public ArrayList<Unfixed> getOperands() {
        return operands;
    }
    public static class Other extends World {

        public Other() {
            super("Неопределенное пространство");
        }

        static private World.Other other;

        public World.Other other() {
            if (other == null) {
                other = new World.Other();
            }
            return other;
        }
    }
}

