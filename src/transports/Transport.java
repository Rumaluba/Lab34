package transports;

import exception.*;
import entity.Entity;
import enums.Locations;
import enums.TransportType;

import java.util.Objects;


public abstract class Transport extends Entity {
    private String color;
    private final TransportType type;
    private boolean DoorPosition;

    public Transport(String color, TransportType type, Locations location, boolean DoorPosition) {
        super(color + " " + type.getNameType(), location);
        this.color = color;
        this.type = type;
        this.DoorPosition = false;
    }

    public TransportType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getDoorPosition() {
        return DoorPosition;
    }

    public void setDoorPosition(boolean doorPosition) {
        this.DoorPosition = doorPosition;
    }

    public abstract void goAway() throws LocationException;

    public void takeIn(Entity entity) throws LocationException {
        try {
            if (this.getLocation() != entity.getLocation())
                throw new LocationException("Объекты, находящиеся в разных локациях не могут взаимодействовать!");
            else if (!getDoorPosition())
                throw new LocationException("Нельзя сесть в транспорт с закрытыми дверьми!");
            else {
                System.out.printf("Объект %s переместился в %s \n", entity.getName(), getName());
                objects.add(entity);
                entity.objects.add(this);
                for (int i = 0; i < entity.getobj().size(); i++)
                    if (!entity.objects.get(i).getobj().contains(this) && !entity.objects.get(i).equals(this)) {
                        takeIn(entity.objects.get(i));
                    }
            }
        } catch (LocationException lex) {
            System.out.println(lex.getMessage());
        }
    }

    public void putAway(Entity entity) {
        System.out.printf("Объект %s покинул %s \n", entity.getName(), getName());
        objects.remove(entity);
        entity.objects.remove(this);
        for (int i = 0; i < entity.getobj().size(); i++)
            if (entity.objects.get(i).getobj().contains(this) && !entity.objects.get(i).equals(this)) {
                putAway(entity.objects.get(i));
            }
    }

    @Override
    public void setLocation(Locations location) throws LocationException {
        this.location = location;
        System.out.printf("%s сменил локацию на %s \n", getName(), location.getLocName());
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Transport that = (Transport) object;
        return Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getColor(), that.getColor()) && type == that.getType();
    }

    @Override
    public String toString() {
        return String.format("транспорт типа %s с названием %s, в локации %s", type.getNameType(), this.getName(), location.getLocName());
    }
}

