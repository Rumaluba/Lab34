import locations.*;
import locations.World;
import entity.Entity;
import entity.Human;
import static enums.Age.*;
import static enums.Gender.*;
import static enums.Volume.*;
import static enums.Drinkables.*;

import exception.*;
import interfaces.Day;
import transports.*;

public class Main {
    public static void main(String[] args) throws LocationException{
        World.Other other = new World.Other();
        Builds.Hospital hospital = new Builds.Hospital();
        Builds.Hospital.RoomWithMedicine roomWithMedicine = hospital.new RoomWithMedicine();
        Builds.KinderGarten kinderGarten = new Builds.KinderGarten();
        Builds.KinderGarten.RoomWithKids roomWithKids = kinderGarten.new RoomWithKids();
        Road road = new Road();
        Road.NearTheHouse nearTheHouse = road.new NearTheHouse();
        Road.Lawn lawn = road.new Lawn();
        House house = new House();
        House.Kitchen kitchen= new House.Kitchen();
        House.Kitchen.kitchenTable table = kitchen.new kitchenTable();
        House.BackRoom backRoom = new House.BackRoom();
        House.BackRoom.TableWithPapers tableWithPapers = backRoom.new TableWithPapers();
        Human Louis = new Human(ADULT, MALE, hospital, "Луис");
        Human children = new Human(CHILD, MALE, road, "Дети");
        Human Rachel = new Human(ADULT, FEMALE, lawn, "Рэчел");
        Human Gage = new Human(BABY, MALE, lawn, "Гэдж");
        Human Elli = new Human(CHILD, FEMALE, nearTheHouse, "Элли");
        Entity voices = new Entity("Гвалт детских голосов", road);
        Human Norma = new Human(ADULT, FEMALE, other, "Норма");
        Bus bus = new Bus("желтый", road);
        Human Jude = new Human(ADULT, MALE, lawn, "Джуд");
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
        day.start();
        Louis.setLocation(roomWithMedicine);
        Louis.setLocation(lawn);
        Rachel.hug(Gage);
        children.take(voices);
        bus.changeDoorPosition();
        bus.takeIn(children);
        bus.changeDoorPosition();
        bus.setLocation(nearTheHouse);
        bus.changeDoorPosition();
        bus.takeOut(children);
        children.setLocation(lawn);
        bus.setColor("Красный");
        Elli.doSmth("оглянулась на родителей");
        bus.takeIn(Elli);
        bus.changeDoorPosition();
        bus.goAway();
        bus.setLocation(kinderGarten);
        bus.changeDoorPosition();
        bus.takeOut(Elli);
        Elli.setLocation(roomWithKids);
        Rachel.doSmth("расплакалась");
        Louis.talk("Ну не надо, ради Бога, это же только на полдня");
        Rachel.continueDialog("И этого достаточно");
        Rachel.endDialog();
        Louis.hug(Rachel);
        Gage.doSmth("молчал");
        Louis.idea("Мы ведь в его полной власти, и он это знает");
        Louis.setLocation(house);
        Rachel.setLocation(kitchen);
        Louis.setLocation(table);
        Louis.breakHug(Rachel);
        Louis.breakHug(Gage);
        Gage.breakHug(Rachel);
        Louis.doSmth("ждал Элли");
        Rachel.doSmth("ждала Элли");
        Louis.drink(COFFEE, ALOT);
        Rachel.drink(COFFEE, ALOT);
        Louis.setLocation(backRoom);
        Louis.setLocation(tableWithPapers);
        Louis.doSmth("перебирал бумажки");
        Rachel.doSmth("до абсурда рано начала рано готовить ланч");
        Rachel.talkPhone("Алло");
        Louis.setLocation(kitchen);
        Louis.idea("звонит учитель Элли, сообщить, что девочка им не подходит и желудок публичного образования не может ее переварить");
        Norma.continuePhoneDialog("Джуд снял остаток кукурузы, и они готовы ей поделиться");
        Norma.endPhoneDialog();
        Louis.doSmth("попенял на Джуда, что тот его позвал на помощь");
        Jude.swear("А она все равно дерьмовая");
        Norma.talk("Будь любезен, не выражаться так, пока я не уйду");
        System.out.println("Информация");
        System.out.println(Elli.toString());
        day.end();
    }
}