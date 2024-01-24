package entity;
import locations.*;
import exception.*;



public class Entity extends Unfixed{
    public Entity(String name, World location) {
        super(name, location);
    }


@Override
    protected void setLocation(World location) throws LocationException {
        try {
            if (!(checkTransport() || checkHumans())) {
                throw new LocationException("Нельзя поменять локацию не умея двигаться и не имея носителя!");
            } else {
                this.location = location;
                System.out.printf("объект %s сменил локацию на %s\n", getName(), location.getLocName());
            }
            for (int i = 0; i < getobj().size(); i++)
                if (getobj().get(i).location != location) {
                    getobj().get(i).setLocation(location);
                }
        } catch (LocationException l) {
            System.out.println(l.getMessage());
        }
    }
    @Override
    public String toString() {
        return String.format("Это объект с названием %s, в локации %s", getName(), location.getLocName());
    }

}
