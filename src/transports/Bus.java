package transports;
import enums.Locations;
import static enums.Locations.*;
import static enums.TransportType.*;
import enums.TransportType;
import exception.*;

public class Bus extends Transport{
    public Bus(String color, Locations location) {
        super("автобус", color, location, BUS);
    }

    public void changeDoorPosition() {
        setDoorPosition(this.getDoorPosition() + 1);
        if (this.getDoorPosition() % 2 != 0) {
            System.out.printf("%s автобус открыл двери\n", this.getColor());
        } else {
            System.out.printf("%s автобус закрыл двери\n", this.getColor());
        }
    }

    @Override
    public void goAway() throws LocationException {
        try {
            this.setLocation(ROAD);
        } catch (LocationException e) {
            System.out.println(e.getMessage());
        }

    }
}
