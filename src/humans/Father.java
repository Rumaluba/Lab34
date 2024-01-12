package humans;
import entity.Entity;
import enums.*;
import interfaces.Parents;
import exception.*;

public class Father extends Human implements Parents {
    public Father(String name, Locations location, Age age, Gender gender) throws GenderException {
        super(name, location, age, gender);
        if (gender != Gender.MALE) throw new GenderException("Папы не могут быть не мужского пола!");
    }
    @Override
    public void waiting(Entity e) {
        System.out.printf("%s ждал %s \n", this.getName(), e.getName());
    }
    @Override
    public void drinkCoffee() {
        System.out.printf("%s пил кофе \n", this.getName());
    }
}
