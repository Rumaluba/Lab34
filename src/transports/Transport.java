package transports;

import exception.*;
import entity.Entity;
import enums.Locations;
import enums.TransportType;

import java.util.Objects;


public abstract class Transport extends Entity {
    public Transport(String name, String color, Locations location, TransportType type) {
        super(name, color, location, type);
    }

    public abstract void goAway() throws LocationException;

    public void takeIn(Entity e) throws LocationException {
        try {
            if (this.getLocation() != e.getLocation())
                throw new LocationException("Объекты, находящиеся в разных локациях не могут взаимодействовать!");
            else if (getDoorPosition() % 2 != 1)
                throw new LocationException("Нельзя сесть в транспорт с закрытыми дверьми!");
            else {
                System.out.printf("Объект %s переместился в %s %s \n", e.getName(), getColor(), getName());
                objects.add(e);
                e.objects.add(this);
                for (int i = 0; i < e.getobj().size(); i++)
                    if (!e.objects.get(i).getobj().contains(this) && !e.objects.get(i).equals(this)) {
                        takeIn(e.objects.get(i));
                    }
            }
        } catch (LocationException w) {
            System.out.println(w.getMessage());
        }
    }
    public void putAway(Entity e) {
        System.out.printf("Объект %s покинул %s %s \n", e.getName(), getColor(), getName());
        objects.remove(e);
        e.objects.remove(this);
        for (int i = 0; i < e.getobj().size(); i++)
            if (e.objects.get(i).getobj().contains(this) && !e.objects.get(i).equals(this)) {
                putAway(e.objects.get(i));
            }
    }

    @Override
    public void setLocation(Locations location) throws LocationException{
        this.location = location;
        System.out.printf("%s %s сменил локацию на %s \n", this.getColor(), this.getName(), this.location.getLocName());
        for (int i = 0; i < getobj().size(); i++)
            if (objects.get(i).getLocation() != location) {
                objects.get(i).objects.remove(this);
                objects.get(i).setLocation(location);
                objects.get(i).objects.add(this);
            }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getColor(), this.getType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport that = (Transport) o;
        return Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getColor(), that.getColor()) && Objects.equals(this.getType(), that.getType());
    }

    @Override
    public String toString() {
        return String.format("Был создан транспорт типа %s с названием %s %s, в локации %s", getType().getNameType(), getColor(), this.getName(), location.getLocName());
    }
}

