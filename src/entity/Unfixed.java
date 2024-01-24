package entity;
import exception.LocationException;
import locations.*;
import transports.Bus;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Unfixed {
        private final String name;
        protected World location;
        protected ArrayList<entity.Unfixed> objects;

        {
            objects = new ArrayList<>();
        }
        private boolean mobility;
    public Unfixed(String name, World location) {
        this.name = name;
        this.mobility = true;
        this.location = location;
        location.setOperands(this);
        this.mobility = false;
    }

    public String getName() {return name;}
    public boolean getMobility() {
        return mobility;
    }
    protected void setMobility(boolean mobility) {
        this.mobility = mobility;
    }
    public World getLocation() {return location;}
    protected abstract void setLocation(World location) throws LocationException;
    public ArrayList<Unfixed> getobj() {
        return objects;
    }
    public void setobj(Unfixed entity) {objects.add(entity);}
    public boolean checkTransport() {
        for (int i = 0; i < getobj().size(); i++) {
            if (getobj().get(i).getClass() == Bus.class && (getobj().get(i).getMobility())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkHumans() {
        for (int i = 0; i < getobj().size(); i++) {
            if ((getobj().get(i).getClass() == Human.class) && (getobj().get(i).getMobility())) {
                return true;
            }
        }
        return false;
    }
    //для всякой бумажной части
    public void doSmth(String smth) {
        System.out.printf("%s %s \n", getName(), smth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Human that = (Human) object;
        return Objects.equals(this.getName(), that.getName());
    }
}
