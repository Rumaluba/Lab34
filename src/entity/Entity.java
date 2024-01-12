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
    private String name;
    protected Locations location;
    public Age age;
    private Gender gender;
    private String color;
    private TransportType type;
    private int doorPosition;
    public final ArrayList<Entity> objects;
    {objects = new ArrayList<>();}

    public Entity(String name, String color, Locations location, TransportType type) {
        this.name = name;
        this.color = color;
        this.location = location;
        this.type = type;
        this.doorPosition = 0;
    }

    public Entity(String name, Locations location, Gender gender) {
        this.name = name;
        this.location = location;
        this.gender = gender;
    }

    public Entity(String name, Locations location, Age age, Gender gender) {
        this.name = name;
        this.location = location;
        this.age = age;
        this.gender = gender;
    }
    public int getDoorPosition() {
        return doorPosition;
    }
    public void setDoorPosition (int doorPosition) {
        this.doorPosition = doorPosition;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public TransportType getType(){
        return type;
    }
    public void setType(TransportType type) {
        this.type = type;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gen) {
        this.gender = gen;
    }
    public  ArrayList<Entity> getobj() {
        return objects;
    }
    public Locations getLocation() {
        return location;
    }

    public void setLocation (Locations location) throws LocationException {
        try{
        if (checkTransport()==1) {
            throw new LocationException("Нельзя поменять локацию не выйдя из транспорта!");
        }
        else if (gender == MALE)  {
            this.location = location;
            System.out.printf("%s сменил локацию на %s\n", name, location.getLocName());
        }
        else if (gender == NEUTRAL) {
            this.location = location;
            System.out.printf("%s сменило локацию на %s\n", name, location.getLocName());
        }
        else {
            this.location = location;
            System.out.printf("%s сменила локацию на %s\n", name, location.getLocName());
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
        System.out.printf("%s %s \n", name,smth);
    }
    public int checkTransport() {
        for  (int i = 0; i < getobj().size(); i++) {
            if (objects.get(i).getClass() == Bus.class){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Был создан объект с названием %s, %s, в локации %s", name,gender.getGenderName(), location.getLocName());
    }

}
