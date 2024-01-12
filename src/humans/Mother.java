package humans;
import entity.Entity;
import enums.*;
import interfaces.Parents;
import exception.*;

public class Mother extends Human implements Parents {
    public Mother(String name, Locations location, Age age, Gender gender) throws GenderException {
        super(name, location, age, gender);
        if (gender != Gender.FEMALE) throw new GenderException("Мамы не могут быть не женского пола!");
    }
    @Override
    public void waiting(Entity e) {
        System.out.printf("%s ждала %s \n", this.getName(), e.getName());
    }
    @Override
    public void drinkCoffee() {
        System.out.printf("%s пила кофе \n", this.getName());
    }
}
