package entity;

import exception.*;
import enums.TransportType;
import locations.*;

import java.util.Objects;


public abstract class Transport extends Unfixed {
    private String color;
    private final TransportType type;
    private boolean doorPosition;

    public Transport(String color, TransportType type, World location) {
        super(color + " " + type.getNameType(), location);
        this.color = color;
        this.type = type;
        this.doorPosition = false;
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
        return doorPosition;
    }

    public void setDoorPosition(boolean doorPosition) throws LocationException {
        if (this.getMobility()) {
            throw new LocationException("Транспорт не может открывать и закрывать двери на ходу");
        } else this.doorPosition = doorPosition;
    }

    public abstract void goAway() throws LocationException;

    public void takeIn(Human human) {
        try {
            if (this.getLocation() != human.getLocation())
                throw new LocationException("Объекты, находящиеся в разных локациях не могут взаимодействовать!");
            else if (!getDoorPosition())
                throw new LocationException("Нельзя сесть в транспорт с закрытыми дверьми!");
            else {
                System.out.printf("Объект %s переместился в %s \n", human.getName(), getName());
                setobj(human);
                human.setobj(this);
                for (int i = 0; i < human.getobj().size(); i++)
                    if (!human.getobj().get(i).getobj().contains(this) && !human.getobj().get(i).equals(this)) {
                        putIn(human.getobj().get(i));
                    }
            }
        } catch (LocationException lex) {
            System.out.println(lex.getMessage());
        }
    }

    protected void putIn(Unfixed unfix) {
        unfix.setobj(this);
        setobj(unfix);
    }

    protected void putOut(Unfixed unfix) {
        objects.remove(unfix);
        unfix.objects.remove(this);

    }

    public void takeOut(Human human) {
        try {
            if (!getDoorPosition())
                throw new LocationException("Нельзя сесть в транспорт с закрытыми дверьми!");
            else {
                System.out.printf("Объект %s покинул %s \n", human.getName(), getName());
                objects.remove(human);
                human.objects.remove(this);
                for (int i = 0; i < human.getobj().size(); i++)
                    if (human.objects.get(i).getobj().contains(this) && !human.objects.get(i).equals(this)) {
                        putOut(human.objects.get(i));
                    }
            }
        } catch (LocationException lex) {
            System.out.println(lex.getMessage());
        }
    }


    @Override
    public void setLocation(World location) throws LocationException {
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

