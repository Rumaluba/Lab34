package entity;

import transports.*;
import enums.Age;
import enums.Gender;
import enums.Locations;
import enums.TransportType;
import exception.*;

import java.util.ArrayList;

import static enums.Gender.*;


public class Entity {
    private final String name;
    protected Locations location;
    public final ArrayList<Entity> objects;

    {
        objects = new ArrayList<>();
    }

    public Entity(String name, Locations location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Entity> getobj() {
        return objects;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) throws LocationException {
        try {
            if (checkTransport()) {
                throw new LocationException("Нельзя поменять локацию не выйдя из транспорта!");
            } else {
                this.location = location;
                System.out.printf("объект %s сменил локацию на %s\n", name, location.getLocName());
            }
            for (int i = 0; i < getobj().size(); i++)
                if (objects.get(i).location != location) {
                    objects.get(i).setLocation(location);
                }
        } catch (LocationException l) {
            System.out.println(l.getMessage());
        }
    }

    //для всякой бумажной части
    public void doSmth(String smth) {
        System.out.printf("%s %s \n", name, smth);
    }

    public boolean checkTransport() {
        for (int i = 0; i < getobj().size(); i++) {
            if (objects.get(i).getClass() == Bus.class) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Это объект с названием %s, в локации %s", name, location.getLocName());
    }

}
