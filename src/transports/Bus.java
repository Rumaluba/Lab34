package transports;
import entity.Transport;
import static enums.TransportType.*;
import exception.*;
import locations.*;

public class Bus extends Transport {
    public Bus(String color, World location) {
        super(color, BUS, location);
    }

    public void changeDoorPosition() throws LocationException{
        setDoorPosition(!this.getDoorPosition());
        if (this.getDoorPosition()) {
            System.out.printf("%s автобус открыл двери\n", this.getColor());
        } else {
            System.out.printf("%s автобус закрыл двери\n", this.getColor());
        }
    }

    @Override
    public void goAway() throws LocationException {
        if (getDoorPosition()) {
            throw new LocationException("Нельзя начать ехать с открытыми дверями");
        }
        else
            try {
                Road road = new Road();
                this.setLocation(road);
            } catch (LocationException e) {
                System.out.println(e.getMessage());
        }

    }
}
