import entity.Entity;
import entity.Human;

import static enums.Age.*;
import static enums.Gender.*;
import static enums.Locations.*;
import static enums.Volume.*;
import static enums.Drinkables.*;

import exception.*;
import interfaces.Day;
import transports.*;

public class Main {
    public static void main(String args[]) throws LocationException, AgeException {
        Human Louis = new Human("Луис", HOSPITAL, ADULT, MALE);
        Human Rachel = new Human("Рэчел", LAWN, ADULT, FEMALE);
        Human Gage = new Human("Гэдж", LAWN, BABY, MALE);
        Human Elli = new Human("Элли", NEARTHEHOUSE, CHILD, FEMALE);
        Human Norma = new Human("Норма", OTHER, ADULT, FEMALE);
        Bus bus = new Bus("желтый", ROAD);
        Entity voices = new Entity("гвалт ребячьих голосов", ROAD);
        Human Jude = new Human("Джуд", LAWN, ADULT, MALE);
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
        bus.objects.add(voices);
        day.start();
        Louis.setLocation(LAWN);
        Rachel.hug(Gage);
        bus.setLocation(NEARTHEHOUSE);
        bus.changeDoorPosition();
        bus.putAway(voices);
        voices.setLocation(SOFTSEMPTEMBERAIR);
        Elli.doSmth("оглянулась на родителей");
        bus.takeIn(Elli);
        bus.changeDoorPosition();
        bus.goAway();
        Rachel.doSmth("расплакалась");
        Louis.talk("Ну не надо, ради Бога, это же только на полдня");
        Rachel.continueDialog("И этого достаточно");
        Rachel.endDialog();
        Louis.hug(Rachel);
        Gage.doSmth("молчал");
        Louis.idea("Мы ведь в его полной власти, и он это знает");
        Rachel.setLocation(KITCHEN);
        Louis.breakHug(Rachel);
        Louis.breakHug(Gage);
        Gage.breakHug(Rachel);
        Louis.doSmth("ждал Элли");
        Rachel.doSmth("ждала Элли");
        Louis.drink(COFFEE, ALOT);
        Rachel.drink(COFFEE, ALOT);
        Louis.setLocation(BACKROOM);
        Louis.doSmth("перебирал бумажки");
        Rachel.doSmth("до абсурда рано начала рано готовить ланч");
        Rachel.talkPhone("Алло");
        Louis.setLocation(KITCHEN);
        Louis.idea("звонит учитель Элли, сообщить, что девочка им не подходит и желудок публичного образования не может ее переварить");
        Norma.continuePhoneDialog("Джуд снял остаток кукурузы, и они готовы ей поделиться");
        Norma.endPhoneDialog();
        Louis.doSmth("попенял на Джуда, что тот его позвал на помощь");
        Jude.swear("А она все равно дерьмовая");
        Norma.talk("Будь любезен, не выражаться так, пока я не уйду");
    }
}