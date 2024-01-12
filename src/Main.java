import entity.Entity;
import humans.*;
import static enums.Age.*;
import static enums.Gender.*;
import static enums.Locations.*;
import static enums.TransportType.*;
import exception.*;
import interfaces.Day;
import transports.*;

public class Main {
    public static void main(String args[]) throws LocationException,AgeException {
        Father a = new Father("Луис", HOSPITAL, ADULT, MALE);
        Mother b = new Mother("Рэчел", LAWN, ADULT, FEMALE);
        Human c = new Human("Гэдж", LAWN, BABY, MALE);
        Human d = new Human("Элли", NEARTHEHOUSE, CHILD, FEMALE);
        Human g = new Human("Норма", FREEEENVIRONMENT, ADULT, FEMALE);
        Bus e = new Bus("апролрпа", "желтый", ROAD, BUS);
        Entity f = new Entity("гвалт ребячьих голосов", ROAD, MALE);
        Human h = new Human("Джуд", LAWN, ADULT, MALE);
        Day day = new Day() {
            @Override
            public void start() {
                System.out.println("День начался");
            }

            @Override
            public void end() {
                System.out.println("День закончился");
            }
        };
        e.objects.add(f);
        day.start();
        a.setLocation(LAWN);
        b.hug(c);
        e.setLocation(NEARTHEHOUSE);
        e.changeDoorPosition();
        e.putAway(f);
        f.setLocation(SOFTSEMPTEMBERAIR);
        d.doSmth("оглянулась на родителей");
        e.takeIn(d);
        e.changeDoorPosition();
        e.goAway();
        b.doSmth("расплакалась");
        a.talk("Ну не надо, ради Бога, это же только на полдня");
        b.continueDialog("И этого достаточно");
        b.endDialog();
        a.hug(b);
        c.doSmth("молчал");
        a.idea("Мы ведь в его полной власти, и он это знает");
        b.setLocation(KITCHEN);
        a.breakHug(b);
        a.breakHug(c);
        c.breakHug(b);
        a.waiting(d);
        b.waiting(d);
        a.drinkCoffee();
        b.drinkCoffee();
        a.setLocation(BACKROOM);
        a.doSmth("перебирал бумажки");
        b.doSmth("до абсурда рано начала рано готовить ланч");
        b.endPhoneDialog();
        b.talkPhone("Алло");
        a.setLocation(KITCHEN);
        a.idea(", что звонит учитель Элли сообщить, что девочка им не подходит и желудок публичного образования не может ее переварить");
        g.continuePhoneDialog("Джуд снял остаток кукурузы, и они готовы ей поделиться");
        a.doSmth("попенял на Джуда, что тот его позвал на помощь");
        h.swear("А она все равно дерьмовая");
        g.talk("Будь любезен, не выражаться так, пока я не уйду");
    }
}